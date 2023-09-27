<template>
    <div id="post">
        <cloudinary-comp msg="Welcome to Your Vue.js App" />
        <table>
            <tr v-for="post in posts" v-bind:key="post.id">
                <td>{{ post.id }}</td>
                <td>{{ post.caption }}</td>
                <td>{{ post.imgUrl }}</td>
            </tr>
        </table>
        <add-post />
    </div>
</template>

<script>
import AddPost from '../components/AddPost.vue';
import cloudinaryComp from '../components/CloudinaryComp.vue'
import postService from '../services/PostService.js';

export default {
    name: 'Post',
    data() {
        return {
            posts: []
        }
    },
    components: {
        cloudinaryComp,
        AddPost
    },
    created() {
        postService.addPost(this.post).then(
            response => {
                this.posts = response.data;
            }
        )
    }
}
</script>

<style></style>