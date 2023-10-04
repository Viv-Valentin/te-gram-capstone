<template>
  <div id="login">
    <form class="form-input" @submit.prevent="login">
      <h1>Please Sign In</h1>
      <div class="fail" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="success" role="alert" v-if="this.$route.query.registration">
        Thank you for registering! Please sign in.
      </div>
      <div class="form-input-group">
        <input type="text" id="username" placeholder="Username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <input type="password" id="password" placeholder="Password" v-model="user.password" required />
      </div>
      <button type="submit">Login</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>  
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
#login {
  display: flex; 
  align-items: center;
  justify-content: center; 
  position: absolute;
  top: 0; bottom: 0; 
  left: 0; right: 0;
  z-index: -1;
  text-align: center;
}

.form-input{
    background-color: rgba(255, 255, 255, 0.5);
    color: rgb(0, 0, 0);
    padding: 2em;
    border-radius: 5px;
    box-shadow: 1px 1px 5px 0  #4D565E;
    width: 300px;
}

.form-input input {
  padding: 7px;
  border-radius: 5px;
  border: 1px #c0c0c0 solid;
  width: 200px;
}

.form-input input:focus {
  border: 1px #00ADEE solid;
  outline: 0;
}

</style>