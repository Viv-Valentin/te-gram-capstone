<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

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
}

#login button:hover {
  background-color: #4D565E;
  color: white;
}

#login button {
  width: 80px;
  height: 30px;
  border-radius: 8px;
  border-style: solid;
  border-width: thin;
  font-weight: bold;
   font-family: serif;

}

div {
 text-align: center;

}

</style>