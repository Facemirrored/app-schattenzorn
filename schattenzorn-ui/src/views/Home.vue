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
    props: {
      error: {
        type: String,
        default: "",
      },
    },
    data() {
      return {};
    },
  };
</script>

<style></style>
