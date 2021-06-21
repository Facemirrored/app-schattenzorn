<template>
  <div id="headline-bar" class="mb-5 row">
    <img class="logo col-2" src="../src/assets/SchattenzornLogo.png" alt="" />
    <h1 class="headline-text mt-5 offset-2 col-8">Schattenzorn</h1>
  </div>
  <navbar></navbar>
  <home></home>
</template>

<script lang="ts">
  import { defineComponent } from "vue";
  import Navbar from "@/components/Navbar.vue";
  import Home from "@/views/Home.vue";

  export default defineComponent({
    name: "App",
    components: {
      navbar: Navbar,
      home: Home,
    },
  });
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    height: 1000px;
    margin-left: 20px;
    margin-top: 20px;
    margin-right: 20px;
  }

  .logo {
    margin-top: 10px;
  }

  .headline-text {
    color: white;
  }

  body {
    background: linear-gradient(
      130deg,
      rgb(2, 0, 0) 30%,
      rgba(255, 0, 0, 0.93) 40%,
      rgb(9, 0, 0) 55%
    );
  }
</style>
