<template>
  <div id="app">
    <div id="header">
      <div class="logo">
        <img src="./assets/FinalLogo.png" alt="TEConnect" />
      </div>
      <div id="nav">
        <ul>
          <li>
            <router-link
              v-bind:to="{ name: 'home' }"
              v-if="$store.state.token != ''"
              >Home</router-link
            >
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'post' }"
              v-if="$store.state.token != ''"
              >Post</router-link
            >
          </li>
          <li>
            <router-link
              v-bind:to="{
                name: 'favorite',
                params: { username: $store.state.user.username },
              }"
              v-if="$store.state.token != ''"
              >Favorites</router-link
            >
          </li>
          <li>
            <router-link
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
#header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  background-color: #fefefe;
  box-shadow: 1px 1px 5px 0 #4d565e;
  position: sticky;
  top: 0;
  left: 0;
  right: 0;
}

#nav > ul {
  display: flex;
  list-style: none;
  text-transform: uppercase;
}

#nav a {
  text-decoration: none;
  color: white;
  margin: 1em;
  background-color: #2b4f60;
  padding: 10px 15px;
  border-radius: 5px;
}

#nav a:hover {
  background-color: #00adee;
}

.logo img {
  max-height: 50px;
  padding: 1em;
}

body {
  background: url("assets/LoginBackground.jpg") #fff center no-repeat fixed;
  background-size: cover;
  font-family: "Avenir", "Helvetica", Arial, sans-serif;
  text-align: left;
  margin: 0;
  color: #4d565e;
}

h1 {
  text-align: center;
  margin: 2em auto 1em auto;
}
h2 {
  text-align: center;
  margin: 0 1em 3em 1em;
  font-weight: normal;
}

label {
  margin-right: 0.5rem;
}

.form-input-group {
  color: #4d565e;
  text-align: center;
  margin: 10px auto 30px;
  border-radius: 15px;
}

a {
  color: #2b4f60;
  transition: all 0.5s ease-in-out;
}
a:hover {
  color: #ff6359;
  text-decoration: none;
}
.fail {
  color: #ff6359;
  margin-bottom: 2em;
}
.success {
  color: #2b4f60;
  margin-bottom: 2em;
}

.username {
  font-weight: bold;
  padding: 10px;
}

.username:before {
  color: #2b4f60;
  content: "@";
}

.caption {
  padding: 15px 10px;
  line-height: 150%;

}

.post-link {
  display: block;
  border-top: 1px solid #dae8f2;
  margin: 0;
  padding: 10px;
}

/* #app > div:nth-child(2) {
margin: 5em auto;
} */
</style>