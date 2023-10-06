<template>
  <div class="post-comments">
      <div class="user-comment" v-for="comment in comments" v-bind:key="comment.commentId">
     {{comment.username}}
    </div>
  </div>

</template>

<script>
import commentService from "../services/CommentService";

export default {

    name: "post-comments",
    data(){
        return {
        comments: [],

        };
    },

    methods: {
        
  },

  created(){
    this.username = this.$store.state.user.username;
    this.postId = this.$route.params.postId;
    commentService.getComments(this.username, this.postId).then((response) => {
    this.post = response.data;
      
    })
    .catch((error) => {
        console.error("Error getting this data for comments!?:", error);
      });
  }
}


</script>

<style>

</style>