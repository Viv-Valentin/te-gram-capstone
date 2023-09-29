<template>
  <div class="user-profile">
      <h1>{{$store.state.user.username}}</h1>
      <div class="profile-feed"
      v-for="post in posts"
      v-bind:key="post.id"> 
      <img v-bind:src="post.imgURL" />
        <div class= "caption">{{ post.caption }}</div>
      </div>
      </div>
      
</template>

<script>

export default {


}
</script>

<style>

</style>