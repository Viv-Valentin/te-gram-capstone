<template>
  <div id="app">
    <div id="nav">
<<<<<<< HEAD
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
=======
      <img src="assets/TEConnect.png" />
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;&nbsp;
>>>>>>> a811b419fa92bbdbd2de912d5b0817ef9a99ff78
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<<<<<<< HEAD
<style>

.form-input-group, h1 {
  margin-bottom: 1rem;
  color: #4D565E;
  font-family: serif;
  text-align: center;
  width: 300px;
  margin: 10px auto 30px;
  border-radius: 15px;
}

label {
  margin-right: 0.5rem;
}

#login {
  padding-top: 200px;
  background-size: cover;
  position: absolute;
  top: 200px;
  right: 0px;
  bottom: 0px;
  left: 0px;
  background-image: url("assets/LoginBackground.jpg");
=======
<script>

export default {
  name: 'App'
>>>>>>> a811b419fa92bbdbd2de912d5b0817ef9a99ff78
}

#login button:hover {
  background-color: #4D565E;
  color: white;
}

<<<<<<< HEAD
#login button {
  width: 80px;
  height: 30px;
  border-radius: 8px;
  border-style: solid;
  border-width: thin;
  font-weight: bold;
   font-family: serif;

=======
body {
  background: url("assets/LoginBackground.jpg") #fff;
  text-align: left;
>>>>>>> a811b419fa92bbdbd2de912d5b0817ef9a99ff78
}

div {
 text-align: center;
<<<<<<< HEAD

}

</style>
=======
}

</style>
>>>>>>> a811b419fa92bbdbd2de912d5b0817ef9a99ff78
