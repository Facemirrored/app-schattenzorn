<template>
  <div v-if="state.loading">
    <div class="row col-12 mt-5 d-flex justify-content-center">
      <div
        class="spinner-border text-primary"
        style="width: 5rem; height: 5rem"
        role="status"
      >
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>
  </div>
  <div v-else class="row">
    <div class="offset-2 col-6 profile-container">
      <div class="row mt-4">
        <div class="col-12 offset-lg-1 col-lg-4">
          <h4 class="">Mein Profil</h4>
        </div>
      </div>
      <hr style="color: white" />
      <div v-if="repoUser" class="row">
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Username:</label><span class="ms-5">{{ repoUser.username }}</span>
        </div>
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Email:</label><span class="ms-5">{{ repoUser.email }}</span>
        </div>
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Rollen:</label><span class="ms-5">{{ repoUser.repoRoles }}</span>
        </div>
      </div>
    </div>
    <hr style="color: white" />
    <div v-for="(character, index) in characters" :key="index" class="row">
      <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
        <label>Name:</label
        ><span class="ms-5">{{ character.characterName }}</span>
        <label>Level:</label><span class="ms-5">{{ character.level }}</span>
        <label>Geschlecht:</label
        ><span class="ms-5">{{ character.male }}</span> <label>Notiz:</label
        ><span class="ms-5">{{ character.notes }}</span>
      </div>
    </div>
    <div class="form-group row ms-2 me-2 mb-4 justify-content-center">
      <button
        class="col-12 col-md-2 btn btn-primary btn-block"
        :disabled="state.loading"
        @click="addCharacter"
      >
        <span
          v-show="state.loading"
          class="spinner-border spinner-border-sm"
        ></span>
        Charakter hinzufügen!
      </button>
    </div>
  </div>
</template>

<script lang="ts">
  import { useStore } from "vuex";
  import { computed, reactive } from "vue";
  import { ActionTypes as AuthActions } from "@/store/auth/types/action-types";
  import { ActionTypes as UserActions } from "@/store/repoUser/types/action-types";
  import { useRouter } from "vue-router";
  import { Character, User } from "@/store/repoUser/interfaces";
  import {
    AddCharacterRequest,
    AddCharacterResponse,
    AddCharacterResponseStatus,
  } from "@/store/interfaces";

  export default {
    name: "Profile",
    setup() {
      const router = useRouter();
      const store = useStore();
      // redirect to home if repoUser is not logged in
      if (!computed(() => store.getters.getLoginStatus).value) {
        router.push("/signIn");
      }
      // data
      const state = reactive({
        loading: false,
        addCharacterMessage: "",
      });
      // get profile data
      const repoUser = computed(() => store.getters.getUser);
      const characters = computed(() => store.getters.getCharacters);
      // get profile data
      if (!repoUser.value) {
        state.loading = true;
        store
          .dispatch(UserActions.LOAD_PROFILE)
          .catch((error) => {
            console.error(error);
            // in error case log repoUser out + clear data and try again
            store.dispatch(AuthActions.LOGOUT).then(() => {
              store
                .dispatch(UserActions.REMOVE_PROFILE)
                .then(() => router.push("/"));
            });
          })
          .finally(() => {
            state.loading = false;
          });
      }
      // add character
      const addCharacter = () => {
        state.loading = true;
        store
          .dispatch(UserActions.ADD_CHARACTER, {} as AddCharacterRequest)
          .then((addCharacterResponse: AddCharacterResponse) => {
            if (
              addCharacterResponse.status === AddCharacterResponseStatus.SUCCESS
            ) {
              state.addCharacterMessage = "";
            } else if (
              addCharacterResponse.status ===
              AddCharacterResponseStatus.USERNAME_TAKEN
            ) {
              state.addCharacterMessage =
                "Es existiert bereits ein Character mit diesem Usernamen";
            }
          })
          .catch((error) => {
            console.error(error);
            state.addCharacterMessage =
              "Es tut uns leid, etwas ist schief gelaufen! Der Admin wurde benachrichtigt.";
          })
          .finally(() => (state.loading = false));
      };
      return {
        addCharacter,
        characters: characters as Character[],
        repoUser: repoUser as User,
        state,
      };
    },
  };
</script>

<style>
  .profile-container {
    margin-top: 50px;
    border: 2px solid #132428;
    background-color: rgba(13, 29, 29, 0.8);
  }
</style>
