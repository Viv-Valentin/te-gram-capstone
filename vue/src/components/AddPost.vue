<template>
  <div id="add-post">
    {{ post }}
    <form v-on:submit.prevent="savePost">
        Caption: <input type="text" v-model="post.caption" />
        <button>Save</button>
    </form>
  </div>
</template>

<script>
import postService from '../services/PostService.js'

export default {
    data() {
        return {
            post: {}
        }
    },
    methods: {
        savePost() {
            postService.addPost(this.post).then(
                response => {
                    if (response.status == 200) {
                        window.alert('Post added');
                        this.$router.push({name: 'home'});
                    }
                }
            )
        }
    }
}
</script>

<style>

</style>