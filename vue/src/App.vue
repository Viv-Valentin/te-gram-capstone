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

<<<<<<< HEAD

=======
>>>>>>> 9a66e1114757bdbf1f47d44700d7cbea9bd3513b
<script>
export default {
  name: 'App'
}
</script>

<<<<<<< HEAD

<style>
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

=======
<style>
>>>>>>> 9a66e1114757bdbf1f47d44700d7cbea9bd3513b
body {
  background: url("assets/LoginBackground.jpg") #fff;
  background-size: cover;
  text-align: left;

}

div {
 text-align: center;
}
<<<<<<< HEAD


.form-input-group {
  color: #4D565E;
  text-align: center;
  margin: 10px auto 30px;
  border-radius: 15px;
}
=======
>>>>>>> 9a66e1114757bdbf1f47d44700d7cbea9bd3513b

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
