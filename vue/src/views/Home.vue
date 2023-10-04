<template>
  <div class="home">
    <h1>Home</h1>
    <h2>Connect with your fellow Tech Elevator alumni here!
        Upload a photo, like a post, or comment to start connecting!
    </h2>
    <div id="feed">
      <div class="feed-post" v-for="post in posts.slice().reverse()" v-bind:key="post.id">
        <div class="username">
          <router-link v-bind:to="{ name: 'username', params: { username: post.username }}">{{ post.username }}</router-link>
        </div>
        <img v-bind:src="post.imgURL" />
        <div class="caption">{{ post.caption }}</div>
        <router-link class="post-link" v-bind:to="{ name: 'details', params: { username: post.username, postId: post.postId }}">Read more</router-link>
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
  margin: 0 auto 5em auto;
  gap: 2em;

}

.home {
  margin: auto;
}

.feed-post {
  width: 400px;
  background: rgba(255, 255, 255, 0.8);

  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;

}

.feed-post img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

.home .caption{
  height: 1.5em;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}


</style>
