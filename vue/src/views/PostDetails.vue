<template>
    <div class="post-details">
          <div class="likes">
          <button v-bind:class="{ unlike: post.like, like: !post.like }" v-on:click="onLikeChange(post)">
            {{ post.like === false ? "Like" : "Unlike" }}
          </button>
        </div>
    </div>
</template>

<script>
export default {
  name: 'post-details',
  post: {
        username: "",
        caption: "",
        imgURL: "",
      },
}
</script>

<style>

</style>