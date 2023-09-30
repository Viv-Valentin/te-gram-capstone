<template>
  <div class="home">
    <h1>Home</h1>
    <p>You have successfully logged in!</p>
      <div class="feed-post" v-for="post in posts.slice().reverse()" v-bind:key="post.id">
        <img v-bind:src="post.imgURL" />
        <div class= "caption">{{ post.caption }}</div>
      </div>
  </div>
</template>

<script>
import postService from '../services/PostService.js';

export default {
  name: "home",
  data() {
    return {
      posts: []
    }
  },
  created() {
    postService.getFeed().then(
      response => {
        this.posts = response.data;
      }
    )
  }
};
</script>

<style>

.home {
  width: 400px;
  margin: auto;
}

.feed-post {
  width: 100%;
}

.feed-post img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

</style>
