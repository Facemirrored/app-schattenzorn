<template>
  <nav class="custom-navbar navbar navbar-expand-lg bg-dark navbar-dark">
    <div class="container-fluid">
      <router-link to="/" class="navbar-brand">
        <img
          src="../assets/house_icon_2.png"
          width="43"
          height="39.6"
          alt="Home"
        />
      </router-link>
      <button
        class="navbar-toggler"
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
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="custom-nav-item nav-item">
            <router-link to="/about" class="nav-link active" aria-current="page"
              >Über Schattenzorn</router-link
            >
          </li>
          <!--          <li class="nav-item">-->
          <!--            <router-link to="/rules" class="nav-link active" aria-current="page"-->
          <!--              >Gildenregeln</router-link-->
          <!--            >-->
          <!--          </li>-->
        </ul>
      </div>
    </div>
  </nav>
</template>

<script lang="ts">
  export default {
    setup() {
      return {};
    },
  };
</script>

<style>
  .custom-navbar {
    margin-left: 200px;
    margin-right: 200px;
    opacity: 0.9;
  }

  .custom-nav-item {
    border-left: 1px solid white;
    border-right: 1px solid white;
  }
</style>
