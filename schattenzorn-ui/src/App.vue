<template class="container">
  <div id="headline-bar" class="mb-5 row">
    <img
      class="logo col-4 col-sm-2 col-md-2 col-lg-2"
      src="../src/assets/SchattenzornLogo.png"
      alt=""
    />
    <h1 class="headline-text mt-5 col-8 col-sm-10 col-md-10 col-lg-10">
      Schattenzorn
    </h1>
  </div>
  <navbar></navbar>
  <router-view v-slot="{ Component }">
    <transition name="custom-fade" mode="out-in">
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

  .headline-text {
    color: white;
  }

  @media screen and (max-width: 539px) {
    h1 {
      font: 600 20px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.1em;
    }
  }

  @media screen and (min-width: 540px) {
    h1 {
      font: 600 28px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.5em;
    }
  }

  @media screen and (min-width: 768px) {
    h1 {
      font: 600 36px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.5em;
    }
  }

  @media screen and (min-width: 992px) {
    h1 {
      font: 600 48px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.5em;
    }
  }

  @media screen and (min-width: 1200px) {
    h1 {
      padding-top: 20px;
      font: 600 60px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.5em;
    }
  }

  @media screen and (min-width: 1600px) {
    h1 {
      padding-top: 50px;
      font: 600 80px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.5em;
    }
  }

  body {
    width: 100%;
    height: auto;
    background: linear-gradient(140deg, black 40%, #045969 50%, #400504 70%)
      no-repeat fixed;
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

  .custom-fade-enter-active,
  .custom-fade-leave-active {
    transition: opacity 0.5s ease;
  }

  .custom-fade-enter-from,
  .custom-fade-leave-to {
    opacity: 0;
  }
</style>
