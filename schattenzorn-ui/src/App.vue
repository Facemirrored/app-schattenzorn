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

  export default defineComponent({
    name: "App",
    components: {
      navbar: Navbar,
    },
    data() {
      return {};
    },
  });
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    height: 1000px;
    margin-left: 10px;
    margin-top: 20px;
    margin-right: 10px;
  }

  .headline-text {
    color: white;
    font-weight: bold;
  }

  .slot-text {
    color: white;
    font-weight: normal;
    opacity: 1;
  }

  @media screen and (max-width: 539px) {
    h1 {
      font: 600 20px "Raleway", sans-serif;
      color: rgba(0, 0, 0, 0.5);
      text-align: center;
      text-transform: uppercase;
      letter-spacing: 0.1em;
    }
    h2 {
      color: #de9c59;
      font-weight: bold;
      font-size: 20px;
    }
    h3 {
      text-align: center;
      color: #ffd971;
      font-weight: bold;
      font-size: 18px;
      letter-spacing: 4px;
      margin-top: 50px;
      margin-bottom: 50px;
    }
    h4 {
      text-align: left;
      color: #ffd971;
      font-weight: bold;
      font-size: 16px;
      letter-spacing: 2px;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    h5 {
      text-align: left;
      color: white;
      font-weight: bold;
      font-size: 14px;
      font-style: italic;
      text-decoration: currentColor solid underline;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin-left: 5px;
      margin-right: 5px;
      text-align: justify;
    }
    p {
      color: white;
      font-family: "Helvetica Neue", sans-serif;
      font-size: 16px;
      line-height: 24px;
      margin: 0 0 24px;
      text-align: justify;
      text-justify: inter-word;
    }
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 20px 0px;
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
    h2 {
      color: #de9c59;
      font-weight: bold;
    }
    h3 {
      text-align: center;
      color: #ffd971;
      font-weight: bold;
      font-size: 20px;
      letter-spacing: 4px;
      margin-top: 50px;
      margin-bottom: 50px;
    }
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 40px 0;
    }
    p {
      color: white;
      font-family: "Helvetica Neue", sans-serif;
      font-size: 18px;
      line-height: 24px;
      margin: 0 0 24px;
      text-align: justify;
      text-justify: inter-word;
    }
    h4 {
      text-align: left;
      color: #ffd971;
      font-weight: bold;
      font-size: 16px;
      letter-spacing: 2px;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    h5 {
      text-align: left;
      color: white;
      font-weight: bold;
      font-size: 14px;
      font-style: italic;
      text-decoration: currentColor solid underline;
      margin-top: 10px;
      margin-bottom: 10px;
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
    h2 {
      color: #ffd971;
      font-weight: bold;
    }
    h3 {
      text-align: center;
      color: #ffd971;
      font-weight: bold;
      font-size: 26px;
      letter-spacing: 4px;
      margin-top: 50px;
      margin-bottom: 50px;
    }
    h4 {
      text-align: left;
      color: #ffd971;
      font-weight: bold;
      font-size: 20px;
      letter-spacing: 2px;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    h5 {
      text-align: left;
      color: white;
      font-weight: bold;
      font-size: 18px;
      font-style: italic;
      text-decoration: currentColor solid underline;
      margin-top: 10px;
      margin-bottom: 10px;
    }
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin: 20px;
      text-align: justify;
    }
    p {
      color: white;
      font-family: "Helvetica Neue", sans-serif;
      font-size: 18px;
      line-height: 24px;
      margin: 0 0 24px;
      text-align: justify;
      text-justify: inter-word;
    }
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 40px 60px;
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
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 40px 60px;
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
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin-bottom: 50px;
      font-size: 22px;
      text-align: justify;
    }
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 100px 50px;
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
    .slot-container {
      border: 2px solid #132428;
      background-color: rgba(13, 29, 29, 0.8);
      margin: 100px 300px;
    }
  }

  body {
    width: 100%;
    height: auto;
    background: linear-gradient(140deg, black 40%, #045969 50%, #400504 70%)
      no-repeat fixed;
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
