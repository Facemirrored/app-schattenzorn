<template>
  <div class="row">
    <div class="offset-2 col-6 profile-container">
      <div class="row mt-4">
        <div class="col-12 offset-lg-1 col-lg-4">
          <h4 class="">Mein Profil</h4>
        </div>
      </div>
      <hr style="color: white" />
      <div class="row">
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
  import { computed } from "vue";
  import { User } from "@/store/auth/interfaces";

  export default {
    name: "Profile",
    setup() {
      const store = useStore();
      return {
        // user from store
        user: computed(() => store.getters.getUser) as unknown as User,
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
