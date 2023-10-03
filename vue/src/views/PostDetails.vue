<template>
  <div class="post-details">
    <div class="username">{{ post.username }}</div>
    <img v-bind:src="post.imgURL" />
    <div class="caption">{{ post.caption }}</div>
    <div class="likes">
      <button v-bind:class="{ unlike: post.like, like: !post.like }" v-on:click="onLikeChange(post)">
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
      this.postId = this.$route.params.postId;

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
  created() {
    this.username = this.$route.params.username;
    this.postId = this.$route.params.postId;

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
.post-details {
  width: 600px;
  background: rgba(255, 255,255, 0.8);
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;
  margin: 5em auto;
}

.post-details img{
  width: 100%;
}
</style>