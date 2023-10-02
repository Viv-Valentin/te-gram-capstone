<template>
  <div class="post-details">
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
  post: {
    username: "",
    caption: "",
    imgURL: "",
  },
  methods: {
    onLikeChange() {
      this.username = this.$route.params.username;
      this.postId = this.$route.params.postId;

      if(this.userHasLiked){
        
        likesService.addFavorite(this.username, this.postId).then((response) => {
        this.posts = response.data;
        
      })}

      else {
         likesService.deleteFavorite(this.username, this.postId).then((response) => {
            this.posts = response.data;
      })
      }
    }
  }
};
//need to look at the above method since it's all kinds of jacked up
// make a variable for userHasLiked, to show if a user has liked a post.
</script>

<style>
</style>