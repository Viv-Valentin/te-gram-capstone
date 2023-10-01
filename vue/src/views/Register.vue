<template>
  <div id="register" class="text-center">
    <form class="register-input" @submit.prevent="register">
      <h1>Create Account</h1>
      <div class="fail" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <input type="text" id="username" placeholder="Username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <input type="text" id="email" placeholder="Email Address" v-model="user.email" required autofocus />
      </div>
      <div class="form-input-group">
        <input type="password" id="password" placeholder="Password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <input type="password" id="confirmPassword" placeholder="Confirm Password" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        email: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Error: Username already taken';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
#register {
  display: flex; 
  align-items: center;
  justify-content: center; 
  position: absolute;
  top: 0; bottom: 0; 
  left: 0; right: 0;
  z-index: -1;


}


.register-input{
    background-color: rgba(255, 255, 255, 0.5);
    color: rgb(0, 0, 0);
    padding: 2em;
    border-radius: 5px;
    box-shadow: 1px 1px 5px 0  #4D565E;
}


</style>
