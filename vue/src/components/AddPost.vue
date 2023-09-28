<template>
  <div id="add-post">
    {{ post }}
    <form v-on:submit.prevent="savePost">
        Caption: <input type="text" v-model="post.caption" />
        Upload: <input type="button" v-on:click.prevent="upload"/>
        <button>Save</button>
    </form>
  </div>
</template>


<script>
import postService from '../services/PostService.js'

export default {
    data() {
        return {
            myWidget : {},
            post: {caption: '', imgURL: ''}
        }
    },
    methods: {
        savePost() {
            postService.addPost(this.post).then(
                response => {
                    if (response.status == 201) {
                        window.alert('Post added');
                        this.$router.push({name: 'home'});
                    }
                }
            )
        },
              upload() {
         let text = "Allow access to Photos and Camera";
         if (confirm(text) == true) {
            this.myWidget.open();
         } else {
           text = "You canceled!";
         }
      }
    },
      mounted() {
       this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here, 
        // see the documentation
        cloudName: 'dfcehgwjs', 
        uploadPreset: 'yff4znjv'
      }, 
      (error, result) => { 
        if (!error && result && result.event === "success") { 
          console.log('Done! Here is the image info: ', result.info); 
          console.log("Image URL: " + result.info.url);
          this.post.imgURL = result.info.url;
        }
      }
    )
  }
}
</script>


<style>
</style>