<template>
  <div class="home">
    <h1>Home</h1>
    <p>You have successfully logged in!</p>
    <div id="feed">
      <div class="feed-post" v-for="post in posts.slice().reverse()" v-bind:key="post.id">
        <img v-bind:src="post.imgURL" />
        <div class= "caption">{{ post.caption }}</div>
        </div>
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

#feed {
  display: flex;
  justify-content: center;
  flex-flow: row wrap;
  margin: auto;
  gap: 2em;

}

.home {
  margin: auto;
}

.feed-post {
  width: 400px;
  background: rgba(255, 255,255, 0.8);
  
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;

}

.feed-post img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

</style>
