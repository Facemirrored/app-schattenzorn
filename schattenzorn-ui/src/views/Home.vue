<template>
  <ContentSlot
    headline="Schattenzorn"
    content="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et
      dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet
      clita
      kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur
      sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam
      voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata
      sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy
      eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et
      justo
      duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.

      Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu
      feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril
      delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet,"
  >
  </ContentSlot>
  <!--  <div class="container welcome-container mt-5">-->
  <!--    <h5>Schattenzorn</h5>-->
  <!--    <p>Willkommen auf dieser noch sehr stumpfen Homepage!</p>-->
  <!--    <p>-->
  <!--      Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy-->
  <!--      eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam-->
  <!--      voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet-->
  <!--      clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit-->
  <!--      amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam-->
  <!--      nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed-->
  <!--      diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.-->
  <!--      Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor-->
  <!--      sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed-->
  <!--      diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam-->
  <!--      erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea-->
  <!--      rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum-->
  <!--      dolor sit amet. Duis autem vel eum iriure dolor in hendrerit in vulputate-->
  <!--      velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis-->
  <!--      at vero eros et accumsan et iusto odio dignissim qui blandit praesent-->
  <!--      luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem-->
  <!--      ipsum dolor sit amet,-->
  <!--    </p>-->
  <!--  </div>-->
</template>

<script lang="ts">
  import ContentSlot from "../components/ContentSlot.vue";

  export default {
    name: "Home",
    components: { ContentSlot },
  };
</script>

<style>
  .welcome-container {
    background: rgba(232, 232, 232, 1);
    border-radius: 10px;
    color: black;
  }

  h1 {
    color: #111;
    font-family: Brush Script MT, Brush Script Std, cursive, sans-serif;
    font-size: 150px;
    font-weight: bold;
    letter-spacing: 3px;
    line-height: 1;
  }

  p {
    color: #685206;
    font-family: "Helvetica Neue", sans-serif;
    font-size: 14px;
    line-height: 24px;
    margin: 0 0 24px;
    text-align: justify;
    text-justify: inter-word;
  }
</style>
