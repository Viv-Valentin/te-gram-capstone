<template>
  <div id="app">
    <img src="./assets/TEConnect.png" alt="TEConnect" />
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
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

body {
  background: url("assets/LoginBackground.jpg") #fff;
  background-size: cover;
  text-align: left;
}

div {
 text-align: center;
}

.form-input-group {
  color: #4D565E;
  text-align: center;
  margin: 10px auto 30px;
  border-radius: 15px;
}

label {
  margin-right: 0.5rem;
}

button {
  width: 80px;
  height: 30px;
  border-radius: 8px;
  border-style: solid;
  border-width: thin;
  font-weight: bold;
}

button:hover {
  background-color: #4D565E;
  color: white;
}

</style>
