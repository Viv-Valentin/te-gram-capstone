<template>
  <div class="post-details">
    <div class="username">{{ this.$route.params.username }}</div>
    <img v-bind:src="post.imgURL" />
    <div class="likes">
        <button class="like material-icons" v-on:click.prevent="like()" v-if="!likeUnlikeToggle">favorite_border</button>
          <button class="unlike material-icons" v-on:click.prevent="unlike()" v-if="likeUnlikeToggle">favorite</button>
    </div>
    <div class="caption">{{ post.caption }}</div>
    
     
   
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
      likeUnlikeToggle: false,
    };
  },

  methods: {
    like() {
      this.username = this.$store.state.user.username;
      likesService.addFavorite(this.username, this.post.postId).then((response) => {
        if (response.status === 200) {
          this.likeUnlikeToggle = true;
          console.log("Added to Favorites");
        }
      });
    },

    unlike() {
      this.username = this.$store.state.user.username;
      likesService
        .deleteFavorite(this.username, this.post.postId)
        .then((response) => {
          if (response.status === 200) {
            this.likeUnlikeToggle = false;
            console.log("Removed from Favorites");
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

    likesService.getLikes(this.$store.state.user.username).then((response) => {
      this.posts = response.data;
      this.posts.forEach(post => {
        if (post.postId === this.postId) {
          this.likeUnlikeToggle = true;
        }
      });
      console.log("Data for likes fetched successfully!:", response.data);
    })
      .catch((error) => {
        console.error("Error getting this data for likes!!!:", error);
      })
  },
};
</script>

<style>
.post-details {
  width: 600px;
  background: rgba(255, 255, 255, 0.8);
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;
  margin: 5em auto;
}

.post-details img {
  width: 100%;
}

.material-icons{
  background: transparent;
  color: #4D565E;
  padding: 0;
  margin: 0;
  
}

.material-icons:hover{
  background: transparent;

}
.likes{
  text-align: left;
  margin: 10px;
}

.post-details .caption{
 padding-top: 0;
}

</style>