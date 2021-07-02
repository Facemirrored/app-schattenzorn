<template>
  <div class="slot-container-small">
    <div class="row">
      <div class="col-12">
        <h3 class="ms-2 mt-3 ms-md-5 me-md-5 mt-md-5">Login</h3>
      </div>
    </div>
    <div v-if="state.loginMessage !== ''" class="row justify-content-center">
      <div class="col-12 mb-4 text-center" style="color: red">
        {{ state.loginMessage }}
      </div>
    </div>
    <form class="mb-5" @submit.prevent="submitForm">
      <div class="row ms-2 me-2 mb-4 justify-content-center">
        <div class="form-group col-12 col-md-2 me-md-4">
          <label for="username" class="col-form-label">Username:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="username"
            v-model="state.signInRequest.username"
            type="text"
            class="form-control custom-input"
            aria-describedby="usernameHelp"
            @blur="v$.username.$touch"
          />
          <div v-if="v$.username.$error" class="ms-md-2 mt-2 input-error">
            {{ v$.username.$errors[0].$message }}
          </div>
        </div>
      </div>
      <div class="row ms-2 me-2 mb-4 justify-content-center">
        <div class="form-group col-12 col-md-2 me-md-4">
          <label for="password" class="col-form-label">Password:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="password"
            v-model="state.signInRequest.password"
            type="password"
            class="form-control custom-input"
            aria-describedby="userPasswordHelp"
            @blur="v$.password.$touch"
          />
          <div v-if="v$.password.$error" class="ms-md-2 mt-2 input-error">
            {{ v$.password.$errors[0].$message }}
          </div>
        </div>
      </div>
      <div class="form-group row ms-2 me-2 mb-4 justify-content-center">
        <button
          class="col-12 col-md-2 btn btn-primary btn-block"
          :disabled="state.loading"
        >
          <span
            v-show="state.loading"
            class="spinner-border spinner-border-sm"
          ></span>
          Login!
        </button>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
  import { computed, reactive } from "vue";
  import { helpers, required } from "@vuelidate/validators";
  import useVuelidate from "@vuelidate/core";
  import { useStore } from "vuex";
  import { ActionTypes } from "@/store/auth/types/action-types";
  import { useRouter } from "vue-router";
  import { SignInRequest, SignInResponseStatus } from "@/store/interfaces";

  // TODO: registrationMessage ausgeben wenn allg. Fehler oder fachl. Fehler
  export default {
    setup() {
      const router = useRouter();
      // get store
      const store = useStore();
      // redirect to profile if user is already logged in
      if (computed(() => store.getters.getLoginStatus).value) {
        router.push("/profile");
      }
      // data
      const state = reactive({
        signInRequest: {
          username: "",
          password: "",
        } as SignInRequest,
        loading: false,
        loginMessage: "",
      });
      // vuelidate
      const rules = {
        username: {
          required: helpers.withMessage(() => "Usernamen eingeben", required),
        },
        password: {
          required: helpers.withMessage(() => "Passwort eingeben", required),
        },
      };
      const v$ = useVuelidate(rules, state.signInRequest);
      // login event
      const handleLogin = () => {
        state.loading = true;
        store
          .dispatch(ActionTypes.SIGN_IN, state.signInRequest)
          .then((signInStatus: SignInResponseStatus) => {
            if (signInStatus === SignInResponseStatus.SUCCESS) {
              state.loginMessage = "";
              router.push("/profile");
            } else {
              state.loginMessage = "Ungültige Login Daten.";
            }
          })
          .catch((error) => {
            console.error(error);
            state.loginMessage =
              "Es tut uns leid, etwas ist schief gelaufen! Der Admin wurde benachrichtigt.";
          })
          .finally(() => (state.loading = false));
      };
      const submitForm = () => {
        v$.value.$touch();
        if (!v$.value.$invalid) {
          handleLogin();
        }
      };
      return {
        state,
        v$,
        submitForm,
      };
    },
  };
</script>

<style scoped>
  @media screen and (max-width: 767px) {
    label {
      color: white;
      font-size: 16px;
    }
    .input-error {
      color: red;
      font-size: 14px;
    }
  }
  @media screen and (min-width: 768px) {
    .input-error {
      color: red;
      font-size: 14px;
    }
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
