<template>
  <div class="row news-slot">
    <div class="news-date col-2 position-relative">
      <div class="d-flex justify-content-center">
        <h2 class="position-relative news-date-day">22</h2>
        <h3 class="position-relative news-date-month">Juni</h3>
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
  .news-date-day {
    font-weight: bold;
    padding-top: 20px;
    z-index: 2;
    text-shadow: 10px 10px 4px #a00101, 0 0 0 black;
  }
  .news-date-month {
    font-weight: bold;
    padding-top: 22px;
    padding-left: 10px;
    z-index: 2;
    text-shadow: 10px 10px 4px #017070, 0 0 0 black;
  }
  .news-image {
    left: -25%;
    top: -15%;
    position: absolute;
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
    color: #de9c59;
    font-weight: bold;
    margin: 100px 300px;
  }
  .news-text {
    color: white;
    font-weight: normal;
    opacity: 1;
  }
</style>
