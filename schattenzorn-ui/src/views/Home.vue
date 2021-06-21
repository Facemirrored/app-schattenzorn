<template>
  <ContentSlot :content-slot-item="aboutUs" />
</template>

<script lang="ts">
  import ContentSlot from "../components/ContentSlot.vue";
  import { ContentSlotItem } from "@/ts/interfaces";

  export default {
    name: "Home",
    components: { ContentSlot },
    data() {
      return {
        aboutUs: {
          headline:
            "Der 'Schattenzorn' ist eine Allianzgilde auf dem deutschen RP-PVE Realm Celebras",
          subHeadline: "Gründung: Mai 2021",
          contentItems: [
            {
              itemHeadline: "Die Entstehung",
              itemTextList: [
                "Einige Mitglieder von uns, spielen fast seit Anfang der Classic Ära zusammen. Und auch wenn sich die Wege mal kurzzeitig trennten, weil viele vorübergehend in anderen Gilden spielten, fanden wir immer wieder zusammen.",
                'Jeder von uns konnte in den unterschiedlichen Gilden seine Erfahrung sammeln. Mit der Zeit und nach einigen Gesprächen, entwickelte sich eine Vorstellung davon wie wohl die "perfekte" Gemeinschaft auszusehen hat.',
                'Als sich das nächste Kapitel (Burning Crusade classic) ankündigte, entschlossen wir uns dazu das Projekt "Schattenzorn" passend zum Start der Erweiterung zu beginnen.',
              ],
            },
            {
              itemHeadline: "Unsere Philosophie",
              itemTextList: [
                'Eine Gilde ist und darf nicht nur Mittel zum Zweck sein, die Freude etwas zu schaffen, ist viel größer wenn man den Erfolg als eingeschworene Gemeinschaft schafft. Dazu gehört natürlich nicht nur die regelmäßige Teilnahme an den Raids, sondern es ist vielmehr ein Miteinander, sich gegenseitig helfen und unterstützen. Der Gedanke dabei sollte nicht "Ich mache das für meinen Erfolg" sondern "Ich mache das für unseren Erfolg" sein.',
              ],
            },
            {
              itemHeadline: "RP? PVE? PVP?",
              itemTextList: [
                "Wir versuchen jeden Bereich abzudecken, der Fokus liegt dabei aber auf den PVE-Inhalten. Das Rollenspiel ist allerdings gerne gesehen und wird auch durch uns gefördert. RP Events werden wir, sofern genügend Interesse besteht planen und durchführen bzw. unterstützen.",
              ],
            },
            {
              itemHeadline: "Unsere Ziele",
              itemTextList: [
                'Unser Ziel ist, dass erfolgreiche Spiel mit einer festen und motivierten Gruppe. Oberste Priorität hat dabei, den Spaß und das "wir Gefühl" nicht aus den Augen zu verlieren.',
              ],
            },
            {
              itemHeadline: "Worauf wir Wert legen",
              itemTextList: [
                'Es sollte selbstverständlich sein, dass jeder weiß worauf es bei seiner Klasse ankommt. Alles andere ist erlernbar und ausbaufähig. Wir legen großen Wert darauf, dass der "Schattenzorn" und seine Mitglieder einen positiven Eindruck auf andere Spieler von "Celebras" hinterlassen.',
              ],
            },
          ],
        } as ContentSlotItem,
      };
    },
  };
</script>

<style>
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
