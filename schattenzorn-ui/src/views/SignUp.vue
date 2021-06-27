<template>
  <div class="slot-container-small">
    <div class="row">
      <div class="col-12">
        <h3 class="ms-2 mt-3 ms-md-5 me-md-5 mt-md-5">Registrieren</h3>
      </div>
    </div>
    <form class="mb-5">
      <div class="row ms-2 me-2 mb-4 justify-content-center">
        <div class="col-12 col-md-2 me-md-4">
          <label for="username" class="col-form-label">Username:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="username"
            type="text"
            class="form-control custom-input"
            aria-describedby="usernameHelp"
          />
        </div>
      </div>
      <div class="row ms-2 me-2 mb-4 justify-content-center">
        <div class="col-12 col-md-2 me-md-4">
          <label for="email" class="col-form-label">Email:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="email"
            type="text"
            class="form-control custom-input"
            aria-describedby="userEmailHelp"
          />
        </div>
      </div>
      <div class="row ms-2 me-2 mb-4 justify-content-center">
        <div class="col-12 col-md-2 me-md-4">
          <label for="password" class="col-form-label">Password:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="password"
            type="password"
            class="form-control custom-input"
            aria-describedby="userPasswordHelp"
          />
        </div>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
  import { useStore } from "vuex";
  import { computed } from "vue";

  export default {
    name: "SignUp",
    setup(props, context) {
      const store = useStore();
      // current user
      const user = computed(() => store.getters.getUser);
    },
  };
</script>

<style scoped>
  @media screen and (max-width: 767px) {
    label {
      color: white;
      font-size: 16px;
    }
  }
  @media screen and (min-width: 768px) {
    label {
      color: white;
      font-size: 20px;
    }
  }
  .custom-input {
    background-color: rgba(22, 22, 22, 0.4);
    color: white;
  }
</style>
