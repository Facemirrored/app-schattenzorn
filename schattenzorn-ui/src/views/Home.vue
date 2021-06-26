<template>
  <news-slot></news-slot>
</template>

<script lang="ts">
  import NewsSlot from "@/components/NewsSlot.vue";
  export default {
    name: "Home",
    components: {
      NewsSlot,
    },
    data() {
      return {};
    },
  };
</script>

<style></style>
