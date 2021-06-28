<template class="row">
  <nav
    class="
      navbar navbar-expand-lg
      col-12 col-sm-12 col-md-10 col-lg-8
      custom-navbar
      mx-auto
    "
  >
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand">
        <img src="../assets/house.svg" alt="Home" />
      </router-link>
      <button
        class="navbar-toggler custom-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div id="navbarSupportedContent" class="collapse navbar-collapse">
        <ul class="navbar-nav mb-2 mb-lg-0 me-auto">
          <li class="pt-1 custom-nav-item nav-item">
            <router-link to="/about" class="nav-link active" aria-current="page"
              >Über Schattenzorn</router-link
            >
          </li>
          <li class="pt-1 custom-nav-item nav-item">
            <router-link to="/rules" class="nav-link active" aria-current="page"
              >Gildenregeln</router-link
            >
          </li>
        </ul>
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="pt-1 custom-nav-item nav-item dropdown">
            <a
              id="navbarDropdown"
              class="nav-link dropdown-toggle"
              href="#"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Account
            </a>
            <ul
              class="dropdown-menu"
              aria-labelledby="navbarDropdown"
              style="background-color: rgba(13, 29, 29, 1)"
            >
              <router-link
                v-if="!loggedIn"
                to="/signUp"
                class="nav-link custom-nav-item dropdown-item"
                aria-current="page"
                >Registrieren</router-link
              >
              <router-link
                v-if="!loggedIn"
                to="/signIn"
                class="nav-link custom-nav-item dropdown-item"
                aria-current="page"
                >Einloggen</router-link
              >
              <router-link
                v-if="loggedIn"
                to="/profile"
                class="nav-link custom-nav-item dropdown-item"
                aria-current="page"
                >Profil</router-link
              >
              <router-link
                v-if="loggedIn"
                to="/"
                class="nav-link custom-nav-item dropdown-item"
                aria-current="page"
                @click="logoutAction"
                >Logout</router-link
              >
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script lang="ts">
  import { useStore } from "vuex";
  import { computed } from "vue";
  import router from "@/router/router";
  import { ActionTypes } from "@/store/auth/types/action-types";

  export default {
    setup() {
      const store = useStore();
      return {
        // login state from store
        loggedIn: computed(() => store.getters.getLoginStatus),
        // logout action from store
        logoutAction: () => store.dispatch(ActionTypes.LOGOUT),
      };
    },
  };
</script>

<style scoped>
  li {
    list-style-type: none;
    margin: 0;
  }

  @media screen and (max-width: 991px) {
    .custom-toggler .navbar-toggler-icon {
      background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(255, 255, 255, 1)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 8h24M4 16h24M4 24h24'/%3E%3C/svg%3E");
    }
    .navbar-toggler {
      border-color: rgb(255, 255, 255);
    }
    .custom-nav-item {
      margin-top: 5px;
      margin-left: 10px;
    }
  }

  @media screen {
    .nav-link:hover {
      color: #2c89a0;
      opacity: 1;
    }
    .nav-link {
      color: #ffd971;
    }
    .custom-navbar {
      color: #ffd971;
      opacity: 0.8;
      background-color: rgba(13, 29, 29, 0.8);
      border: 2px solid #132428;
      font-weight: bold;
    }
  }
</style>
