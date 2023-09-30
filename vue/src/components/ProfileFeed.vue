<template>
  <div class="user-profile">
    <h1>{{ loggedUser }}</h1>
    <div id="user-feed">
    <div
      class="profile-feed"
      v-for="post in posts.slice().reverse()"
      v-bind:key="post.id">
   
      <img v-bind:src="post.imgURL" />
    </div>
    </div>
  </div>
</template>

<script>
import postService from "../services/PostService";

export default {
  name: "profile-feed",
  data() {
    return {
      loggedUser: this.$store.state.user.username,
      profileUser: "",
      posts: [],
      filter: this.username,
    };
  },
  created() {
    postService.getPosts(this.$route.params.username).then((response) => {
      this.posts = response.data;

      // need to check on this to make sure it's done correctly -viv
    });
  },
  computed: {
    filteredPosts() {
      return this.posts.filter((post) => {
        this.filter === "" ? true : this.filter === post.username;
      });
    },
  },
  methods: {
    getUserFeed() {
      postService.getPhotos(this.username).then((response) => {
        if (response.status == 404) {
          this.newPost = response.data;
        }
      });
    },
  },
};
</script>

<style>

#user-feed{
  display: flex;
  justify-content: center;
  flex-flow: row wrap;
  margin: auto;
  gap: 2em;
}

.profile-feed{
  width: 400px;
  background: rgba(255, 255,255, 0.8);
  
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;  
}

.profile-feed img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}
</style>