<template>
  <div class="home">
     <img alt="Vue logo" src="assets/logo.png">
    <cloudinary-comp msg="Welcome to Your Vue.js App"/>
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
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
