<template>
  <div class="user-profile">
    <user-profile />
      <!-- <h1>{{$store.state.user.username}}</h1>
      <div class="profile-posts" v-for="post in filteredPosts" v-bind:key="post.id">
        <img v-bind:src="post.imgURL" />
        </div>
      <div class="profile-feed"
      v-for="post in posts"
      v-bind:key="post.id"> 
      <img v-bind:src="post.imgURL" />
        <div class= "caption">{{ post.caption }}</div>
      </div> -->
      </div>
      
</template>

<script>
import userProfile from "../components/ProfileFeed.vue"

export default {
  
  components: {
    userProfile
  }


}
</script>

<style>

</style>