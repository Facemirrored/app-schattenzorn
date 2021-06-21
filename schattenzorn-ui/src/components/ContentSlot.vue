<template>
  <div class="row content-slot"></div>
</template>

<script lang="ts">
import {defineComponent, PropType} from "vue";
import { TextContent } from "@/ts/interfaces";

export default defineComponent ({
  props: {
    headline: {
      type: String,
      required: true,
    },
    content: {
      type: Object as PropType<TextContent[]>,
      required: true,
    }
  },
  setup() {
    return {
    }
  }
})

</script>

<style>

.content-slot {
  margin-left: 100px;
  margin-right: 100px;
}

</style>