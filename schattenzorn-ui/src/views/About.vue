<template>
  <div class="slot-container">
    <div class="row">
      <div class="col-12 mt-3 text-center">
        <h3 class="ms-2 mt-3 ms-lg-5 me-lg-5">{{ title }}</h3>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph1 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph2 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph5 }}
        </p>
      </div>
    </div>
    <hr style="color: white" />
    <h3>{{ subTitle1 }}</h3>
    <div class="row">
      <div class="col-12">
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph7 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph9 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph10 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph11 }}
        </p>
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph12 }}
        </p>
      </div>
    </div>
    <hr style="color: white" />
    <h3>{{ subTitle2 }}</h3>
    <div class="row">
      <div class="col-12">
        <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">
          {{ paragraph13 }}
        </p>
      </div>
    </div>
    <hr style="color: white" />
    <h3>{{ subTitle3 }}</h3>
    <div class="row">
      <div class="mt-3 col-12">
        <p class="center-highlight">{{ paragraph15 }}</p>
      </div>
    </div>
    <hr style="color: white" />
    <h3>{{ subTitle4 }}</h3>
    <div class="row">
      <div class="col-12">
        <ul>
          <li class="list-item">
            <p class="ms-2 me-2">{{ paragraph16 }}</p>
          </li>
          <li class="list-item">
            <p class="ms-2 me-2">{{ paragraph17 }}</p>
          </li>
          <li class="list-item">
            <p class="ms-2 me-2">{{ paragraph18 }}</p>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
  export default {
    name: "Home",
    data() {
      return {
        title:
          "Schattenzorn - eine Allianzgilde auf dem deutschen RP-PVE Realm Celebras",
        paragraph1:
          "Azeroth – oder auch WoW – ist eine besondere Welt in einem großen Universum, ein Reich voll starker Magie und mächtiger Wesen. Seit dem Anbeginn der Zeit haben diese Mächte Azeroth und den umliegenden Kosmos beeinflusst, Sterne in Bewegung gesetzt und über das Schicksal zahlloser Welten und sterblicher Zivilisationen bestimmt.",
        paragraph2:
          "Bevor jedoch der Schattenzorn Gestalt annahm, gab es unterschiedliche Erlebnisse und Erfahrungen – und an manchen Stellen wohl auch Leere und Enttäuschung. Einige unserer tapferen Recken fanden sich bereits seit Anfang der Classic Ära zusammen, kämpften sich durch endlose scheinende Welten und erlebten so manche Abenteuer. Alles war in Bewegung und in einem steten Wandel begriffen, so gingen manche neue Wege, andere blieben zurück und wieder andere fanden erneut zusammen.",
        paragraph5:
          "All diese unterschiedlichen Erfahrungen, die ein Jeder im Laufe der Zeit sammelte, führten nach und nach zu einer Vorstellung davon, wie eine Gemeinschaft aussehen sollte, die einem Ziel gemeinsam folgt. Als sich die Schaffung des dunklen Portals ankündigte, jenes, das in das nächste große Kapitel (Burning Crusade Classic) führen würde, war es auch an der Zeit, den „Schattenzorn“, passend zur Öffnung des Portals, zum Leben zu erwecken.",
        subTitle1: "Unsere Philosophie",
        paragraph7:
          "Licht und Schatten sind die grundlegendsten Kräfte der Existenz. Und auch, wenn sie von Natur aus entgegengesetzt wirken, sind sie doch in der kosmischen Ordnung miteinander verbunden. Das Eine kann ohne das Andere nicht sein. Das heißt, eine Gilde ist und darf nicht nur ein Mittel zum Zweck sein. Die Freude, etwas zu schaffen, etwas erreicht zu haben, ist viel größer, wenn man den Erfolg als eingeschworene Gemeinschaft erreicht.",
        paragraph9:
          "Hierbei geht es nicht nur um die regelmäßige Teilnahme an den Raids, sondern es ist vielmehr ein Miteinander, sich gegenseitig zu helfen und zu unterstützen. Der Gedanke sollte dabei nicht lauten: „Ich mach das für meinen Erfolg.“ – sondern vielmehr: „Ich mach das für UNSEREN Erfolg!“",
        paragraph10:
          "Die Mächte von Leben und Tod halten jedes Lebewesen des materiellen Universums in ihrem Griff und die Energien des Lebens – gemeinhin auch als Naturmagie bezeichnet – fördern das Wachstum und die Erneuerung aller Dinge.",
        paragraph11:
          "Soll heißen, es wird immer ein Kommen und Gehen geben, es wird immer wieder mal Stürme, Licht und Schatten geben, doch soll dies als Chance gesehen werden, dass wir als Gemeinschaft daran wachsen und dass die Mächte von Ordnung und Chaos ausgewogen gehandhabt werden können – und hierzu sind auch Gildenregeln unerlässlich.",
        paragraph12:
          'Wie die elementare Dualität, welche die Elemente mit ihren zahlreichen Zuständen beeinflussen kann, gibt es auch hier die unterschiedlichsten Strömungen und Vorlieben: "RP?, PVE?, PVP?"',
        subTitle2: "Unser Motto - Leben und leben lassen!",
        paragraph13:
          "Wir versuchen jeden Bereich abzudecken, der Fokus liegt dabei aber auf den PVE-Inhalten. Das Rollenspiel ist jedoch immer gern gesehen und wird so weit wie möglich gefördert. RP-Events werden, sofern auch genügend Interesse besteht, geplant und durchgeführt bzw. unterstützt. Anregungen, Aktivitäten hierzu sind herzlich willkommen!",
        subTitle3: "Unser Ziel",
        paragraph15:
          "Erfolgreiches Spiel mit einer motivierten und möglichst konstanten Gruppe. Oberste Priorität hierbei ist, den Spaß zu erleben und das Wir-Gefühl nicht aus den Augen zu verlieren.",
        subTitle4: "Unser Credo",
        paragraph16:
          "Das Klassenverständnis sollte vorhanden sein – bei Unklarheiten hierzu helfen und unterstützen wir uns gegenseitig!",
        paragraph17:
          "Alles andere ist erlernbar und ausbaufähig – aber niemand wird benachteiligt, weil WoW nicht schon seit Jahren Bestandteil im Leben des anderen ist.",
        paragraph18:
          "Und unbestritten sollte sein, dass Schattenzorn mit seinen Mitgliedern einen positiven Eindruck bei anderen Spielern von Celebras hinterlässt – es mag eine virtuelle Welt sein, das rechtfertig jedoch nicht, sich wie die Axt im Walde zu benehmen.",
      };
    },
  };
</script>

<style scoped>
  @media screen and (max-width: 539px) {
    .center-highlight {
      font-family: "Adobe Caslon Pro", "Hoefler Text", Georgia, Garamond, Times,
        serif;
      color: #ffd971;
      margin-left: 30px;
      margin-right: 30px;
      letter-spacing: 0.1em;
      line-height: 120%;
      font-variant: small-caps;
      text-transform: lowercase;
      text-align: center;
    }
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin-left: 5px;
      margin-right: 5px;
      text-align: justify;
    }
  }
  @media screen and (min-width: 768px) {
    .center-highlight {
      font-family: "Adobe Caslon Pro", "Hoefler Text", Georgia, Garamond, Times,
        serif;
      color: #ffd971;
      margin-left: 100px;
      margin-right: 100px;
      letter-spacing: 0.1em;
      line-height: 145%;
      font-variant: small-caps;
      text-transform: lowercase;
      text-align: center;
    }
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin: 20px;
      text-align: justify;
    }
  }
  @media screen and (min-width: 1200px) {
    .center-highlight {
      font-family: "Adobe Caslon Pro", "Hoefler Text", Georgia, Garamond, Times,
        serif;
      color: #ffd971;
      margin-left: 180px;
      margin-right: 180px;
      letter-spacing: 0.1em;
      line-height: 145%;
      font-variant: small-caps;
      text-transform: lowercase;
      text-align: center;
    }
    li {
      list-style-type: upper-roman;
      color: #ffd971;
      margin-bottom: 50px;
      font-size: 22px;
      text-align: justify;
    }

    .list-item {
      margin-left: 50px;
      padding-left: 10px;
      padding-right: 30px;
      padding-top: 20px;
      width: 90%;
      height: 75px;
      border: gold 1px solid;
      background: linear-gradient(
          90deg,
          rgba(74, 109, 109, 0.4) 40%,
          rgba(205, 85, 85, 0.4) 60%
        )
        no-repeat fixed;
      transform: skewX(-30deg);
      transform-origin: top;
      /* Zentriert den Inhalt */
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .list-item > p {
      transform: skewX(30deg);
      opacity: 1;
    }
  }
  p:first-letter {
    text-transform: uppercase;
  }
  h3 {
    text-align: center;
    color: #ffd971;
    font-weight: bold;
    font-size: 26px;
    letter-spacing: 4px;
    margin-top: 50px;
    margin-bottom: 50px;
  }
</style>
