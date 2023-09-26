<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <cloudinary-comp msg="Welcome to Your Vue.js App"/>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<<<<<<< HEAD
<style>

body {
background: url("assets/TEConnect.png") no-repeat;
text-align: left;
background-color: white;
}

</style>
=======
<script>
import cloudinaryComp from './components/CloudinaryComp.vue'

export default {
  name: 'App',
  components: {
    cloudinaryComp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
>>>>>>> 3114c115d36ff2f66a34be5fe71412a02faefa1f
