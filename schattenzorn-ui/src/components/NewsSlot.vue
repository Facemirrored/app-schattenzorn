<template>
  <div class="row news-slot">
    <div class="news-date col-2 position-relative">
      <div class="d-flex justify-content-center">
        <h2 class="position-relative" style="padding-top: 20px; z-index: 2">
          22
        </h2>
        <h3
          class="position-relative"
          style="padding-top: 22px; padding-left: 10px; z-index: 2"
        >
          Juni
        </h3>
      </div>
      <img
        class="news-image"
        src="../assets/ImpossibleToroidalPolyhedron.svg"
        alt=""
        width="250"
        height="250"
      />
    </div>
    <div class="news-content col-10">
      <h2>Homepage Erstellung</h2>
      <hr />
      <p class="news-text">
        Willkommen auf der Homepage! Diese befindet sich aktuell im Aufbau und
        es wird versucht, diese täglich zu erweitern! :)
      </p>
    </div>
  </div>
</template>

<script lang="ts">
  export default {
    name: "NewsSlot",
  };
</script>

<style scoped>
  .news-image {
    left: -25%;
    top: -15%;
    position: absolute;
    opacity: 0.5;
    z-index: 1;
  }
  .news-date {
    padding-left: 40px;
    margin-top: 20px;
  }
  .news-content {
    margin-top: 20px;
  }
  .news-slot {
    border: 2px solid #132428;
    background-color: rgba(13, 29, 29, 0.8);
    color: white;
    margin: 100px 300px;
  }
  .news-text {
    color: white;
    opacity: 1;
  }
</style>
