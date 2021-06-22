<template>
  <div class="row content-slot">
    <h2 class="text-center mt-4">{{ contentSlotItem.headline }}</h2>
    <h3 class="text-center mb-5">{{ contentSlotItem.subHeadline }}</h3>
    <div
      v-for="(contentItem, index) in contentSlotItem.contentItems"
      :key="index"
    >
      <h4>{{ contentItem.itemHeadline }}</h4>
      <p
        v-for="(itemText, subIndex) in contentItem.itemTextList"
        :key="subIndex"
        class="content-text"
      >
        {{ itemText }}
      </p>
    </div>
  </div>
</template>

<script lang="ts">
  import { defineComponent, PropType } from "vue";
  import { ContentSlotItem } from "@/ts/interfaces";

  export default defineComponent({
    props: {
      contentSlotItem: {
        required: true,
        type: Object as PropType<ContentSlotItem>,
      },
    },
    setup() {
      return {};
    },
  });
</script>

<style scoped>
  h4 {
    font-size: 18px;
    margin-left: 80px;
  }

  .content-slot {
    border: 2px solid #132428;
    background-color: rgba(13, 29, 29, 0.8);
    color: white;
    margin: 100px 300px;
  }
  .content-text {
    margin-left: 100px;
    margin-right: 100px;
    color: white;
    opacity: 1;
  }
</style>
