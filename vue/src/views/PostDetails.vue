<template>
  <div class="post-details">
    <div class="username">{{ this.$route.params }}</div>
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
import likesService from "../services/LikesService";
import postService from "../services/PostService";

export default {
  name: "post-details",
  data() {
    return {
      post: [],
    };
  },
  methods: {
    onLikeChange() {
      this.username = this.$route.params.username;
      this.postId = this.$route.params.postId; // wont work bc params doesn't have postId! :zany_face:

      likesService.getLikes(this.username).then((response) => {
        if (response.data.includes(this.postId)) {
          likesService
            .deleteFavorite(this.username, this.postId)
            .then((response) => {
              this.posts = response.data;
            }),
            likesService
              .addFavorite(this.username, this.postId)
              .then((response) => {
                this.posts = response.data;
              });
        }
      });
    },
  },
  // setLike(value) {
  //   this.$store.commit("SET_READ_STATUS", { post: this.post, value: value });
  // },
  created() {
    this.username = this.$route.params.username;
    this.postId = this.$route.params.postId; // also wont work bc params doesn't have postId! :zany_face:

    postService
      .getPost(this.username, this.postId)
      .then((response) => {
        this.post = response.data;
        console.log("Data fetched successfully!:", response.data);
      })
      .catch((error) => {
        console.log(this.$route.params.username);
        console.log(this.$route.params.postId);
        
        console.error("Error fetching data!!!:", error);
      });
  },
};
</script>

<style>
</style>