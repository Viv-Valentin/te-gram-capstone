<template>
  <div id="app">
    <div id="header">
      <div class= "logo">
    <img src="./assets/FinalLogo.png" alt="TEConnect" />
    </div>
    <div id="nav">
      <ul>
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li><router-link  v-bind:to="{ name: 'post' }" v-if="$store.state.token != ''">Post</router-link></li>
        <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
      </ul>
      </div>
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

#header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: rgba(255, 255,255, 0.8);
  box-shadow: 1px 1px 5px 0  #4D565E;
}

#nav > ul  {
  display: flex;
  list-style: none;
  text-transform: uppercase;
  
}

#nav a {
   text-decoration: none;
   color: white;
   margin: 1em;
   background-color:  #2B4F60;
   padding: 10px 15px;
   border-radius: 5px;
}

#nav a:hover {
   background-color:    #00ADEE
}


.logo img {
  max-height: 50px;
  padding: 1em;
}

body {
  background: url("assets/LoginBackground.jpg") #fff;
  background-size: cover;
  font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  text-align: left;
  margin: 0;

}

div {
 text-align: center;
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

.form-input-group {
  color: #4D565E;
  text-align: center;
  margin: 10px auto 30px;
  border-radius: 15px;
}
</style>