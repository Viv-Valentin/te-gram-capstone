<template>
  <div id="post">
    <h2 id="username" v-on:click="$router.push(`/profile/${post.username}`)">
      {{ post.username }}
    </h2>

    <vueper-slides
      id="image-slideshow"
      class="no-shadow"
      :slide-ratio="1 / 4"
      fixed-height="500px"
    >
      <vueper-slide
        v-for="image in post.images"
        :key="image.id"
        :content="tagImage(image)"
      />
    </vueper-slides>

    <div id="button-box">
      <button
        id="like"
        class="bluehover"
        v-on:click="
          {
            unlikePost();
          }
        "
        v-if="liked"
      >
        <i class="fas fa-heart"></i>
      </button>
      <button
        id="like"
        class="bluehover"
        v-on:click="
          {
            likePost();
          }
        "
        v-else
      >
        <i class="far fa-heart"></i>
      </button>
      <button
        id="comments-link"
        class="bluehover"
        v-on:click="$router.push(`/postDetails/${post.postId}`)"
      >
        <i class="far fa-comment"></i>
      </button>
    </div>
    <div id="box-4-likes">
      <p>{{ post.likeNumber }} Likes</p>
    </div>
    <p id="datetime">POSTED {{ timeSince }} AGO</p>

    <div id="caption">
      <p>
        <strong> {{ post.username }}</strong> {{ post.caption }}
      </p>
    </div>

    <comments
      id="comments"
      :postId="post.postId"
      :commentList="post.comments"
    />
  </div>
</template>

<script>
import postService from "../services/PostService.js";
import Comments from "../components/Comments.vue";
import { VueperSlides, VueperSlide } from "vueperslides";
import "vueperslides/dist/vueperslides.css";

export default {
  props: {
    post: Object,
  },
  components: { VueperSlides, VueperSlide, Comments },
  computed: {
    liked() {
      return this.post.liked;
    },
    timeSince() {
      let seconds = this.post.secondsAgo;

      var interval = seconds / 31536000;

      if (interval > 1) {
        return Math.floor(interval) + " YEARS";
      }
      interval = seconds / 2592000;
      if (interval > 1) {
        return Math.floor(interval) + " MONTHS";
      }
      interval = seconds / 86400;
      if (interval > 1) {
        return Math.floor(interval) + " DAYS";
      }
      interval = seconds / 3600;
      if (interval > 1) {
        return Math.floor(interval) + " HOURS";
      }
      interval = seconds / 60;
      if (interval > 1) {
        return Math.floor(interval) + " MINUTES";
      }
      return Math.floor(seconds) + " SECONDS";
    },
  },
  methods: {
    tagImage(url) {
      return `<img src="${url}" class="slide-img"/>`;
    },
    likePost() {
      console.log(this.post.images);
      postService
        .addLiked(this.post.postId)
        .then((response) => {
          if (response.status == 201) {
            this.$store.commit("TOGGLE_LIKE", this.post);
          }
        })
        .catch((error) => {
          console.log(error.response);
        });
    },
    unlikePost() {
      postService
        .removeLiked(this.post.postId)
        .then()
        .catch((error) => {
          console.log(error.response);
        });
      this.$store.commit("TOGGLE_LIKE", this.post);
    },   
  },
};
</script>

<style scoped>
#post {
  margin-top: 2rem;
  padding: 1.4rem;
  grid-gap: 0.5rem;
  width: 600px;
  border-radius: 10px;
  background-color: rgb(241, 248, 243);
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "username . ."
    "image image image"
    "btns"
    "likes . ."
    "caption caption caption"
    "comments comments comments"
    "datetime datetime .";
}

#post #username {
  font-size: 1.5rem;
  grid-area: username;
  margin: 0;
}

#datetime {
  grid-area: datetime;
  font-weight: 300;
  color: rgba(100, 100, 100, 1);
  font-size: 0.75rem;
}

#caption {
  grid-area: caption;
  padding: 0;
  margin: 0;
}

#caption p {
  font-size: 1rem;
  font-family: "Spartan", "Arial", sans-serif;
}

#image-slideshow {
  grid-area: image;
  background-color: rgb(241, 248, 243);
  justify-content: center;
}

.slide-img {
  height: 400px;
  max-height: 100%;
  max-width: 100%;
  margin-bottom: 10px;
}

#button-box {
  grid-area: btns;
  display: flex;
  justify-content: left;
  margin-bottom: 0.5rem;
}

#like,
#comments-link,
#share {
  font-size: 1.8rem;
}

#box-4-likes {
  grid-area: likes;
  padding: 0;
}

#box-4-likes p,
#caption p {
  margin: 0;
}

#box-4-likes p {
  font-weight: bold;
}

#comments {
  grid-area: comments;
}

.submit-btn {
  align-self: flex-end;
}

.bluehover:hover,
.submit-btn:hover {
  background-color: #00adee;
}

button {
  border: 0;
  background-color: rgb(241, 248, 243);
  cursor: pointer;
}
</style>