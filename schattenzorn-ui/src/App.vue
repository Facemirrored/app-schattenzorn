<template>
  <navbar></navbar>
</template>

<script>

import Navbar from "@/components/Navbar";

export default {
  name: 'App',
  components: {
    navbar: Navbar,
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
  background: linear-gradient(120deg, rgba(0,0,0,1) 20%, rgba(255,151,0,1) 40%, rgba(0,0,0,1) 60%);
}
</style>
