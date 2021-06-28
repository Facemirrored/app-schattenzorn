<template>
  <div class="slot-container-small">
    <div class="row">
      <div class="col-12">
        <h3 class="ms-2 mt-3 ms-md-5 me-md-5 mt-md-5">Registrieren</h3>
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
            v-model="state.signUpRequest.username"
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
          <label for="email" class="col-form-label">Email:</label>
        </div>
        <div class="col-12 col-md-4">
          <input
            id="email"
            v-model="state.signUpRequest.email"
            type="text"
            class="form-control custom-input"
            aria-describedby="userEmailHelp"
            @blur="v$.email.$touch"
          />
          <div v-if="v$.email.$error" class="ms-md-2 mt-2 input-error">
            {{ v$.email.$errors[0].$message }}
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
            v-model="state.signUpRequest.password"
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
          class="col-12 col-md-4 btn btn-primary btn-block"
          :disabled="state.loading"
        >
          <span
            v-show="state.loading"
            class="spinner-border spinner-border-sm"
          ></span>
          Jetzt Registrieren!
        </button>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
  import { useStore } from "vuex";
  import { computed, reactive } from "vue";
  import router from "@/router/router";
  import {
    SignUpStatus,
    SignUpResponse,
    SignUpRequest,
  } from "@/store/auth/interfaces";
  import { ActionTypes } from "@/store/auth/types/action-types";
  import useVuelidate from "@vuelidate/core";
  import {
    email,
    helpers,
    maxLength,
    minLength,
    required,
  } from "@vuelidate/validators";

  // TODO: registrationMessage ausgeben wenn allg. Fehler oder fachl. Fehler
  export default {
    name: "SignUp",
    setup() {
      const store = useStore();
      // redirect to profile if user is already logged in
      if (computed(() => store.getters.getLoginStatus).value) {
        router.push("/profile");
      }
      // data
      const state = reactive({
        signUpRequest: {
          username: "",
          email: "",
          password: "",
        } as SignUpRequest,
        registrationState: {} as SignUpStatus,
        loading: false,
        registrationMessage: "",
      });
      // vuelidate
      const rules = {
        username: {
          required: helpers.withMessage(() => "Usernamen eingeben", required),
          min: helpers.withMessage(() => "Mindestens 3 Zeichen", minLength(3)),
          max: helpers.withMessage(() => "Maximal 20 Zeichen", maxLength(20)),
        },
        password: {
          required: helpers.withMessage(() => "Passwort eingeben", required),
          min: helpers.withMessage(() => "Mindestens 6 Zeichen", minLength(6)),
          max: helpers.withMessage(() => "Maximal 40 Zeichen", maxLength(40)),
        },
        email: {
          required: helpers.withMessage(() => "Email eingeben", required),
          email: helpers.withMessage(() => "Invalides Format", email),
          max: helpers.withMessage(() => "Maximal 50 Zeichen", maxLength(50)),
        },
      };
      const v$ = useVuelidate(rules, state.signUpRequest);
      // registration event
      const handleRegistration = () => {
        state.loading = true;
        store
          .dispatch(ActionTypes.SIGN_UP, state.signUpRequest)
          .then((signUpResponse: SignUpResponse) => {
            state.registrationState = signUpResponse.signupStatus;
            if (state.registrationState === SignUpStatus.SUCCESS) {
              state.registrationMessage =
                "Du wurdest soeben erfolgreich registriert!";
            } else if (
              state.registrationState === SignUpStatus.FAILED_EMAIL_TAKEN
            ) {
              state.registrationMessage =
                "Unter dieser Email befindet sich bereits ein registrierter Account.";
            } else if (
              state.registrationState === SignUpStatus.FAILED_USERNAME_TAKEN
            ) {
              state.registrationMessage =
                "Der Username ist leider bereits vergeben.";
            } else {
              // TODO: BOOM...status nicht existent
            }
          })
          .catch((error) => {
            // TODO: error nutzen für logging
            state.registrationMessage =
              "Es tut uns leid, etwas ist schief gelaufen! Der Admin wurde benachrichtigt.";
          })
          .finally(() => (state.loading = false));
      };
      const submitForm = () => {
        v$.value.$touch();
        if (!v$.value.$invalid) {
          handleRegistration();
        }
      };
      return {
        v$,
        state: state,
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
