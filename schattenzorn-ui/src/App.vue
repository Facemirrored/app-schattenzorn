<template>
  <navbar></navbar>
  <home></home>
</template>

<script>

import Navbar from "@/components/Navbar";
import Home from "@/views/Home";

export default {
  name: 'App',
  components: {
    navbar: Navbar,
    home: Home,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 1000px;
}

body {
  background: rgb(0,0,0);
  background: linear-gradient(130deg, rgb(255, 255, 255) 30%, rgba(255, 0, 0, 0.93) 40%, rgb(255, 255, 255) 55%);
}
</style>
