<template>
  <div class="home">
    <h1>Home</h1>
    <p>You have successfully logged in!</p>
    <table>
      <tr v-for="post in posts" v-bind:key="post.id">
        <td>{{ post.id }}</td>
        <td>{{ post.username }}</td>
        <td>{{ post.caption }}</td>
        <td>{{ post.imgUrl }}</td>
        <td>{{ post.timestamp }}</td>
      </tr>
    </table>
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
