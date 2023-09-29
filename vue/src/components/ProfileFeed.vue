<template>
    <div class="user-profile">
        <h1>{{ $store.state.user.username }}</h1>
        <div class="profile-feed" v-for="post in posts" v-bind:key="post.id">
            <img v-bind:src="post.imgURL" />
            <div class="caption">{{ post.caption }}</div>
            
                  <div class="feedpost" v-for="post in posts.slice().reverse()" v-bind:key="post.id">
        <img v-bind:src="post.imgURL" />
        <div class= "caption">{{ post.caption }}</div>
      </div>
            

            
        </div>
    </div>
</template>

<script>
import postService from '../services/PostService'

export default {
    name: 'profile-feed',
    data() {
        return {
            username: this.$store.state.user.username,
            newPost: [],
            filter: this.username,
        };
    },
    created(){
        postService.getPosts(this.$route.params.username).then(response => {
            this.posts = response.data;
            
            // need to check on this to make sure it's done correctly -viv
        })
    },
    computed: {
        filteredPosts() {
            return this.posts.filter(post => {
                this.username === this.selectedUser
            });
        }
    },
    methods: {
        getUserFeed() {
            postService.getPhotos(this.username).then(
                response => {
                    if (response.status == 404) {
                        this.newPost = response.data;
                    }
                }
            )
        }
    }
}
</script>

<style></style>