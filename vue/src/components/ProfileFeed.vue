<template>
  <div class="profile-feed">
    <h1>{{ username }}</h1>
    <div class="user-feed">
    <div class="user-post" v-for="post in posts.slice().reverse()" v-bind:key="post.id">
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
}

.profile-feed {
  margin: auto;
}
</style>