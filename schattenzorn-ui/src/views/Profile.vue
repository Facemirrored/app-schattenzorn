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
      <div v-if="user" class="row">
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Username:</label><span class="ms-5">{{ user.username }}</span>
        </div>
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Email:</label><span class="ms-5">{{ user.email }}</span>
        </div>
        <div class="col-12 offset-lg-1 col-lg-4" style="color: white">
          <label>Rollen:</label><span class="ms-5">{{ user.roles }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
  import { useStore } from "vuex";
  import { computed, reactive } from "vue";
  import { User } from "@/store/auth/interfaces";
  import { ActionTypes } from "@/store/auth/types/action-types";
  import { useRouter } from "vue-router";

  export default {
    name: "Profile",
    setup() {
      const router = useRouter();
      const store = useStore();
      // redirect to home if user is not logged in
      if (!computed(() => store.getters.getLoginStatus).value) {
        router.push("/");
      }
      // data
      const state = reactive({
        loading: false,
      });
      // get user
      const user = computed(() => store.getters.getUser);
      console.log("user", user.value);
      // load user, if not contained (can happen if page is reloaded)
      if (!user.value) {
        state.loading = true;
        console.log("fetch profile");
        store
          .dispatch(ActionTypes.LOAD_PROFILE)
          .catch((error) => {
            console.error(error);
            // in error case log user out and try again
            store.dispatch(ActionTypes.LOGOUT).then(() => router.push("/"));
          })
          .finally(() => {
            state.loading = false;
          });
      }
      return {
        user,
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
