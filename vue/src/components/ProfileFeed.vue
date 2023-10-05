<template>
  <div class="profile-feed">
    <h1>{{ username }}'s Profile</h1>
    <h2>Explore the stories and moments captured by {{ username }}!</h2>
    <nav><router-link v-bind:to="{ name: 'favorite', params: { username: username }}">View Favorite Posts</router-link></nav>
    <div class="user-feed">
    <div class="user-post" v-for="post in posts.slice().reverse()" v-bind:key="post.postId">
      <router-link v-bind:to="{ name: 'details', params: { username: post.username, postId: post.postId }}">
        <img v-bind:src="post.imgURL" />
      </router-link>
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
      posts: [],
    };
  },
  created() {
    this.username = this.$route.params.username;
    postService.getPosts(this.username).then(
      response => {
        this.posts = response.data;
      }
    )
  }
};
</script>

<style>
.user-feed {
  display: flex;
  justify-content: center;
  flex-flow: row wrap;
  margin: 0 auto 5em auto;
  gap: 2em;
}
.user-post {
  width: 400px;
  background: rgba(255, 255,255, 0.8);
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;
}

.user-post img {
  width: 100%;
  height: 300px;
  object-fit: cover;
  transition: all 0.5s ease-in-out;
}

.user-post img:hover {
  opacity: 0.8;
}

.profile-feed {
  margin: auto;
}

.profile-feed nav{
  text-align: center;
  font-size: 20px;
  padding-bottom: 2em;
}
</style>