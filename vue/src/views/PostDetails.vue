<template>
  <div class="post-details">
    <div class="username">{{ post.username }}</div>
        <img v-bind:src="post.imgURL" />
        <div class="caption">{{ post.caption }}</div>
    <div class="likes">
      <button
        v-bind:class="{ unlike: post.like, like: !post.like }"
        v-on:click="onLikeChange(post)"
      >
        {{ post.like === false ? "Like" : "Unlike" }}
      </button>
    </div>
  </div>
</template>

<script>
import likesService from '../services/LikesService';


export default {
name: "post-details",
 data() {
    return {
      props: {
        post: Object
    },
      post: [],
    };
  },
  methods: {
      onLikeChange() {
      this.username = this.$route.params.username;
      this.postId = this.$route.params.postId;
      likesService.getLikes(this.username).then((response) => {
        if (this.postId === response.data) {
          likesService.deleteFavorite(this.username, this.postId).then((response) => {
            this.posts = response.data;
        }),
        likesService.addFavorite(this.username, this.postId).then((response) => {
        this.posts = response.data;
      })}
    })
    }
  }
};

</script>

<style>

</style>