<template>
  <div class="row content-slot">
    <h2>{{ contentSlotItem.headline }}</h2>
    <h3>{{ contentSlotItem.subHeadline }}</h3>
    <div
      v-for="(contentItem, index) in contentSlotItem.contentItems"
      :key="index"
    >
      <h4>{{ contentItem.itemHeadline }}</h4>
      <p
        v-for="(itemText, index) in contentItem.itemTextList"
        :key="index"
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
  .content-slot {
    border: 2px solid #402003;
    background-color: rgba(60, 21, 6, 0.8);
    color: white;
    margin: 50px 300px;
  }
  .content-text {
    color: white;
    opacity: 1;
  }
</style>
