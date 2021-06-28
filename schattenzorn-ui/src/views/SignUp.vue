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
            v-model="user.username"
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
            v-model="user.email"
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
            v-model="user.password"
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
          :disabled="loading"
        >
          <span
            v-show="loading"
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
  import { SignUpState, SignUpStatus, User } from "@/store/auth/interfaces";
  import { ActionTypes } from "@/store/auth/types/action-types";
  import useVuelidate from "@vuelidate/core";
  import {
    email,
    helpers,
    maxLength,
    minLength,
    required,
  } from "@vuelidate/validators";

  export default {
    name: "SignUp",
    setup() {
      const store = useStore();
      // redirect to profile if user is already logged in
      if (computed(() => store.getters.getLoginStatus).value) {
        router.push("/profile");
      }
      // data
      const user = reactive({
        username: "",
        password: "",
        email: "",
        token: "",
      } as User);
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
      const v$ = useVuelidate(rules, user);
      // registration event
      let registrationState: SignUpState = undefined;
      let loading = false;
      let registrationMessage: string;
      const handleRegistration = (user: User) => {
        loading = true;
        store
          .dispatch(ActionTypes.SIGN_UP, user)
          .then((signUpStatus: SignUpStatus) => {
            registrationState = signUpStatus.signupState;
            if (registrationState === SignUpState.SUCCESS) {
              registrationMessage =
                "Du wurdest soeben erfolgreich registriert!";
            } else if (registrationState === SignUpState.FAILED_EMAIL_TAKEN) {
              registrationMessage =
                "Unter dieser Email befindet sich bereits ein registrierter Account.";
            } else if (
              registrationState === SignUpState.FAILED_USERNAME_TAKEN
            ) {
              registrationMessage = "Der Username ist leider bereits vergeben.";
            } else {
              // TODO: BOOM...status nicht existent
            }
          })
          .catch((error) => {
            // TODO: error nutzen für logging
            registrationMessage =
              "Es tut uns leid, etwas ist schief gelaufen! Der Admin wurde benachrichtigt.";
          })
          .finally(() => (loading = false));
      };
      return {
        v$,
        user,
        handleRegistration,
        registrationState,
        registrationMessage,
        loading,
      };
    },
    methods: {
      submitForm() {
        this.v$.$touch();
        if (!this.v$.$invalid) {
          this.handleRegistration(this.user);
        }
      },
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
