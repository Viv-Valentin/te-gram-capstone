<template>
  <div class="home">
    <cloudinary-comp msg="Welcome to Your Vue.js App"/>
    <h1>Home</h1>
    <p>You have successfully logged in!</p>
  </div>
</template>

<script>
import CloudinaryComp from '../components/CloudinaryComp.vue';


export default {
  name: "home",
  components: {
    CloudinaryComp,
  }
};
</script>
