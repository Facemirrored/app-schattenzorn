<template>
  <div id="headline-bar" class="mb-5 row">
    <img class="logo col-2" src="../src/assets/SchattenzornLogo.png" alt="" />
    <h1 class="headline-text mt-5 offset-2 col-8">Schattenzorn</h1>
  </div>
  <navbar></navbar>
  <router-view v-slot="{ Component }">
    <transition name="slide">
      <component :is="Component"></component>
    </transition>
  </router-view>
</template>

<script lang="ts">
  import { defineComponent } from "vue";
  import Navbar from "@/components/Navbar.vue";

  const DEFAULT_TRANSITION = "fade";

  export default defineComponent({
    name: "App",
    components: {
      navbar: Navbar,
    },
    data() {
      return {
        prevHeight: 0,
        transitionName: DEFAULT_TRANSITION,
      };
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
    width: 100%;
    height: auto;
    background: linear-gradient(130deg, black 20%, #045969 40%, #400504 80%)
      no-repeat fixed;
  }

  h1 {
    color: #111;
    font-family: Brush Script MT, Brush Script Std, cursive, sans-serif;
    font-size: 150px;
    font-weight: bold;
    letter-spacing: 5px;
    line-height: 1;
  }

  p {
    color: #685206;
    font-family: "Helvetica Neue", sans-serif;
    font-size: 14px;
    line-height: 24px;
    margin: 0 0 24px;
    text-align: justify;
    text-justify: inter-word;
  }

  .slide-enter-active {
    position: absolute;
    transition: all 0.85s ease;
  }

  .slide-leave-active {
    position: absolute;
    transition: all 0.5s ease;
    opacity: 0;
  }

  .slide-enter-from {
    left: -100%;
  }

  .slide-enter-to {
    left: 0;
  }

  .slide-leave-from {
    transform: scale(1);
  }
</style>
