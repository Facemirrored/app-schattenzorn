<template>
  <div id="slot-item-wrapper">
    <div
      v-for="(newsItem, index) in newsSlotItems"
      :key="index"
      class="slot-container"
    >
      <div class="row mt-3 mb-md-4 mb-lg-5">
        <div class="col-12 col-md-5 col-lg-4 position-relative">
          <div class="row">
            <div class="col-3 col-sm-2 col-md-4">
              <img
                class="news-image"
                src="../assets/ImpossibleToroidalPolyhedron.svg"
                alt=""
              />
            </div>
            <div class="col-9 col-sm-10 col-md-8 pt-3 news-date">
              <h2 class="position-relative news-date">{{ newsItem.date }}</h2>
            </div>
          </div>
        </div>
        <div class="col-12 col-md-7 col-lg-8">
          <h3 class="ms-2 mt-3 me-3">{{ newsItem.title }}</h3>
        </div>
      </div>
      <hr style="color: white" />
      <div class="row">
        <div class="col-12">
          <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
            {{ newsItem.content }}
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
  import { NewsSlotItem } from "@/ts/interfaces";

  export default {
    name: "NewsSlot",
    data() {
      return {
        newsSlotItems: [
          {
            date: "26 Juni",
            title: '"Über Schattenzorn" und "Gildenregeln" erstellt',
            content:
              "Ab jetzt besitzen wir eine schicke Übersicht aller Gildenregeln sowie die Entstehungsgeschichte!",
          },
          {
            date: "22 Juni",
            title: "Homepage Erstellung",
            content:
              "Willkommen auf der Homepage! Diese befindet sich aktuell im Aufbau und es wird versucht, diese täglich zu erweitern! :)",
          },
        ] as NewsSlotItem[],
      };
    },
  };
</script>

<style scoped>
  @media screen and (max-width: 767px) {
    .news-date {
      padding-left: 10px;
      padding-top: 5px;
      font-weight: bold;
      z-index: 2;
      text-shadow: 10px 10px 4px #017070, 0 0 0 black;
    }
    .news-image {
      position: relative;
      z-index: 1;
      left: 10px;
      width: 60px;
      height: auto;
    }
  }

  @media screen and (min-width: 768px) {
    .news-date {
      padding-left: 10px;
      font-weight: bold;
      z-index: 2;
      text-shadow: 10px 10px 4px #017070, 0 0 0 black;
    }
    .news-image {
      position: absolute;
      left: 20px;
      z-index: 1;
      width: 70px;
      height: auto;
    }
  }

  @media screen and (min-width: 992px) {
    #slot-item-wrapper {
      margin-left: 200px;
      margin-right: 200px;
    }
    .news-image {
      position: absolute;
      left: 20px;
      z-index: 1;
      width: 75px;
      height: auto;
    }
  }

  @media screen and (min-width: 1200px) {
    .news-image {
      position: absolute;
      left: 20px;
      z-index: 1;
      width: 95px;
      height: auto;
    }
  }
</style>
