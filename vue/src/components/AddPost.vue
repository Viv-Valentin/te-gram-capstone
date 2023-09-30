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
          <textarea id="caption" v-model="post.caption"></textarea>
        </div>
        <div class="save-input">
          <button>Save</button>
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
  
}

.caption-input label {
  display: block;
}

.new-post{
  width: 600px;
  background: rgba(255, 255,255, 0.8);
  padding: 1em;
  border-radius: 5px;
  box-sizing: border-box;
  margin: auto;

}

.new-post img{
    width: 100%;

}

.new-post textarea{
    width: 100%;
    height: 7em;
}

.upload-input{
    margin: 4em;
}

.upload-input input, button{
   text-decoration: none;
   color: white;
   margin: 1em;
   background-color:  #2B4F60;
   padding: 10px 15px;
   border-radius: 5px;
   border: 0;
   text-transform: uppercase;
  
}

.upload-input input:hover, button:hover{
background-color: #00ADEE
}
</style>
