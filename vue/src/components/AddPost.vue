<template>
  <div id="add-post">
    <form v-on:submit.prevent="savePost">
      <div class="upload-input">
        <input type="button" value="Upload Photo" v-on:click.prevent="upload" />
      </div>

      <div class="new-post" v-if="post.imgURL != ''">
        <img v-bind:src="post.imgURL" />
        <div class="caption-input">
          <label for="caption">Caption:</label>
          <textarea
              v-model="post.caption" 
              placeholder="Type your caption here!" 
              name="" 
              maxlength="500" 
              cols="30" 
              rows="10"  id="caption"
              ></textarea>
          <span id="caption-counter">{{ caption.length }} / 500</span>
          //TODO try the counter again!
          
        </div>
        <div class="save-input">
          <button>Post</button>
        </div>
      </div>
    </form>
  </div>
</template>


<script>
import postService from "../services/PostService.js";

export default {
  data() {
    return {
      myWidget: {},
      caption: '',
      post: {
        username: this.$store.state.user.username,
        caption: "",
        imgURL: "",
      },
    };
  },
  methods: {
    savePost() {
      postService.addPost(this.post).then((response) => {
        if (response.status == 201) {
          window.alert("Post added");
          this.$router.push({ name: "home" });
        }
      });
    },
    upload() {
      let text = "Allow access to Photos and Camera";
      if (confirm(text) == true) {
        this.myWidget.open();
      } else {
        text = "You canceled!";
      }
    },
  },
  mounted() {
    this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here,
        // see the documentation
        cloudName: "dfcehgwjs",
        uploadPreset: "yff4znjv",
      },
      (error, result) => {
        if (!error && result && result.event === "success") {
          console.log("Done! Here is the image info: ", result.info);
          console.log("Image URL: " + result.info.url);
          this.post.imgURL = result.info.url;
        }
      }
    );
  },
};
</script>

<style>
#add-post {
  margin: 5em auto;
  text-align: center;
}

.caption-input label {
  display: block;
}

textarea {
  max-width: 100%;
  min-width: 100%;
  max-height: 300px;
}

.new-post {
  width: 600px;
  background: rgba(255, 255, 255, 0.8);
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;
  margin: auto;
}

.new-post img {
  width: 100%;
}

.new-post textarea {
  width: 100%;
  height: 7em;
}

.upload-input {
  margin: 4em;
}

.upload-input input,
button {
  text-decoration: none;
  color: white;
  margin: 1em;
  background-color: #2b4f60;
  padding: 10px 15px;
  border-radius: 5px;
  border: 0;
  text-transform: uppercase;
}

.upload-input input:hover,
button:hover {
  background-color: #00adee;
}
</style>
