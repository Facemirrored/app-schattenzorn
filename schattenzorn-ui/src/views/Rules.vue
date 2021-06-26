<template>
  <div class="slot-container">
    <div class="row">
      <div class="col-12 mt-3 text-center">
        <h3 class="ms-2 mt-3 ms-lg-5 me-lg-5">{{ title }}</h3>
      </div>
    </div>
    <div v-for="(guildRule, index) in guildRules" :key="index" class="row">
      <div class="col-12">
        <h4 class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5 mb-4 mt-5">
          {{ guildRule.paragraph }}
        </h4>
      </div>
      <div
        v-for="(passage, passageIndex) in guildRule.passages"
        :key="passageIndex"
      >
        <div class="col-12">
          <h5
            v-if="passage.passageHeadline !== ''"
            class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5 mb-lg-4"
          >
            {{ passage.passageHeadline }}
          </h5>
        </div>
        <div v-if="passage.list">
          <ul class="col-12">
            <li
              v-for="(rule, ruleIndex) in passage.rules"
              :key="ruleIndex"
              class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5"
            >
              <p>{{ rule }}</p>
            </li>
          </ul>
        </div>
        <div v-else>
          <div
            v-for="(rule, ruleIndex) in passage.rules"
            :key="ruleIndex"
            class="col-12"
          >
            <p class="ms-2 me-2 ms-md-3 me-md-3 ms-lg-5 me-lg-5">{{ rule }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
  import { GuildRule, Passage } from "@/ts/interfaces";

  export default {
    name: "Rules",
    data() {
      return {
        title: "Gildenregeln",
        guildRules: [
          {
            paragraph: "§1 Verhalten",
            passages: [
              {
                passageHeadline: "1.1 Verhalten gegenüber anderen Spielern",
                list: false,
                rules: [
                  "Ein vernünftiger und respektvoller Umgang innerhalb und außerhalb der Gilde steht für uns an erster Stelle. Beim Spielen zusammen mit Anderen, verhalten wir uns fair und fallen nicht durch negatives Verhalten auf.",
                  "Wir bitten auch Nicht-Gildenmitglieder darum, uns über Fehlverhalten unserer Spieler zu informieren!",
                  "Im Gilden.-Gruppenchat, Discord (inklusive der Voice-Kanäle) erwarten wir einen höflichen und respektvollen Umgangston.",
                  "Jeder hat die Zeit, wenn er online kommt kurz seine Gildenkollegen im Chat zu begrüßen und sich zu verabschieden.",
                ],
              },
              {
                passageHeadline: "1.2 Umgang mit anderen Spielern",
                list: false,
                rules: [
                  "Wir sind hilfsbereit und unterstützen uns gegenseitig, sofern dies möglich ist. Sollte ein Gildenmitglied eine Frage haben, wird diese mit bestem Gewissen beantwortet.",
                  'Eine Antwort ist auch ein "Nein", oder "Das weiß ich leider nicht.',
                  "Ein nichtanworten (ignorieren) hat nichts mit respektvollen Umgang miteinander zu tun und wird nicht gerne gesehen.",
                  'Es ist völlig normal, dass sich im Laufe der Zeit Spielergruppen zusammenfinden, die viel oder ausschließlich etwas zusammen machen. Oft ist es so, dass sich mehrere "Grüppchen" in einer Gilde entwickeln. Wir würden uns sehr wünschen, dass dies so gut es geht vermieden wird und Spieler von uns nicht "links liegen gelassen werden".',
                ],
              },
              {
                passageHeadline:
                  "1.3 Beleidigungen, anstößige oder rassistische Äußerungern (auch Medien)",
                list: false,
                rules: [
                  "Rassistische, beleidigende oder anstößige Äußerungen, Nicknames, Medien, werden auf keiner unserer Plattformen geduldet und führen zum sofortigen Auschluss.",
                ],
              },
            ] as Passage[],
          },
          {
            paragraph: "§2 Discord",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  "Die Nutzung des Discord-Servers wird nicht vorausgesetzt. Es ist aber erwünscht bzw. von Vorteil sich dort einzufinden oder gelegentlich mal reinzuschauen. Es erleichtert die Absprache und ihr kommt schneller an Neuigkeiten und Informationen. Abgesehen von der Erleichterung des Gruppenspiels, ist es eine schöne Möglichkeit euch auszutauschen oder einfach mal zu unterhalten.",
                  "Jeder der unseren Discord-Server nutzt, achtet darauf, dass seine Beiträge/Post´s auch in den entsprechenden Channel gelangen.",
                ],
              },
            ],
          },
          {
            paragraph: "§3 Streit",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  'Leider kommt es auch in "World of Warcraft" immer mal wieder zu Auseinandersetzungen und Missverständnissen. Diese sind in der Regel überflüssig. Sollte dies einmal der Fall sein, könnt ihr gerne, bevor der Konflikt eskaliert, auf uns zukommen. Jedes "Problem" kann gelöst werden.',
                ],
              },
            ],
          },
          {
            paragraph: "§4 Anwesenheit",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  "Wir schreiben unseren Mitgliedern NICHT vor, wann und wie lange sie zu spielen haben. Das reale Leben geht IMMER vor. Wir erwarten aber, dass Spieler die sich für Veranstaltungen/Events/Raids etc. anmelden, auch zu dem jeweiligen Zeitpunkt anwesend sind. Natürlich kann auch hier im RL immer etwas dazwischen kommen. Eine kurze Information an uns wäre sehr erwünscht.",
                ],
              },
            ],
          },
          {
            paragraph: "§5 Inaktivität",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  'Spieler die länger als einen Monat abwesend sind werden gebeten sich vorher "abzumelden". Sie bekommen den Rang "Abwesend". Mitglieder mit diesem Rang werden nicht aus der Gilde entfernt. Sobald ihr wieder aktiv seid, bekommt ihr euren ursprünglichen Rang zurück.',
                  "Spieler die länger als 2 Monate unabgemeldet abwesend sind, werden aus der Gilde ausgeschlossen. Sie haben natürlich die Möglichkeit sich wieder anzuschließen, wenn sie wieder aktiv sind, verlieren aber ihren Gildenrang.",
                ],
              },
            ],
          },
          {
            paragraph: "§6 Veranstaltungen/Events",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  "Veranstaltungen und Events planen wir und geben sie über unseren Discord-Server bekannt. Dort hat jeder Spieler die Möglichkeit sich an oder abzumelden. Desweiteren hat jeder Spieler die Möglichkeit, dort seine eigene Veranstaltung (z.b. ein Dungeon) zu planen. Dabei ist darauf zu achten, dass sich Einträge nicht oder nur wenig überschneiden, um die Übersicht zu wahren.",
                ],
              },
            ],
          },
          {
            paragraph: "§7 Aufnahme neuer Mitglieder/Anwärterzeit",
            passages: [
              {
                passageHeadline: "",
                list: false,
                rules: [
                  'Es ist erwünscht, dass sich jedes Gildenmitglied aktiv an der Rekrutierung neuer Mitglieder beteiligt. Sollte ein Spieler interessiert sein der Gilde beizutreten, kann er durch ein Mitglied (ab Rang "Veteran" möglich) eingeladen werden.',
                  'Neue Mitglieder bekommen zunächst den Rang "Neuling", dieser bleibt für 4 Wochen und dient dazu, dass sie sich in der Gilde orientieren und entscheiden können, ob es die Richtige für sie ist.',
                  'Entscheiden sie sich für einen Verbleib, werden sie zu "Probemitglied" befördert. Ab diesem Zeitpunkt beginnt eine Probezeit von 2 Monaten. Sollte der Spieler sich in dieser Zeit angemessen verhalten und entwickelt haben wird er zum "Mitglied" befördert.',
                  "Die Gildenleitung behält sich vor, Gildenmitglieder schneller zu befördern oder ihnen direkt einen höheren Rang zu zuweisen. Dies passiert z.b bei einem besonderen Engagement oder einer besonderen Funktion.",
                ],
              },
            ],
          },
          {
            paragraph: "§8 Ränge und ihre Bedeutung",
            passages: [
              {
                passageHeadline: "",
                list: true,
                rules: [
                  "Gildenmeister: Gildenmeister",
                  "Offizier: Offiziere, rechte Hand des Gildenmeisters",
                  "Raidoffizier: Plant und organisiert Raids / Raidleitung",
                  "Offiziers-Twink: gleiche Rechte wie der Offizier",
                  "Schatzmeister: Hat neben den Offizieren zugriff auf Gilden und Raidbanken",
                  "Veteran: Spieler die schon länger in der Gilde sind / Spieler mit besonderem Engagement",
                  "Raidmitglied: Mitglieder die mit uns aktiv raiden",
                  "Mitglied: volles Mitglied der Gilde",
                  "Probemitglied: Befindet sich in der Probezeit",
                  "Neuling: Neuankömmlinge",
                  "Twink: Twinks von Mitgliedern",
                  "Abwesend: Inaktive, abgemeldete Spieler",
                ],
              },
            ],
          },
          {
            paragraph: "§9 Raids",
            passages: [
              {
                passageHeadline: "",
                rules: [
                  'In unseren Raids gelten gesonderte Regeln, diese lest ihr bitte unter dem Menüpunkt "Raids" nach.',
                ],
              },
            ],
          },
          {
            paragraph: "§10 Gildenbank/Raidbank",
            passages: [
              {
                passageHeadline: "",
                rules: [
                  "Gilden und Raidbanken werden transparent und für jeden einsehbar geführt.",
                  "Ein Anrecht auf die Gegenständer der Raidbank hat ein Spieler nur, wenn er auch aktiv mit uns raidet.",
                  'Allgemein gilt die Regel "geben und nehmen". Das bedeutet, ein Spieler hat nur dann ein Anrecht auf Gegenstände von einer Bank, wenn er auch etwas eingezahlt hat. Dies können Goldbeträge oder Gegenstände (verbrauchbare Güter wie Erze, Kräuter, Tränke, Elixiere etc.) sein.',
                  'Alles was Mitglieder entnehmen bzw. entnehmen lassen, sollte im Verhältnis zudem stehen, was sie "einzahlen".',
                  "Gegenstände die zwingend für die Raids gebraucht werden, sind davon nicht betroffen und werden gesondert behandelt.",
                ],
              },
            ],
          },
          {
            paragraph: "§10 Mitgestaltung, Mitwirkung",
            passages: [
              {
                passageHeadline: "",
                rules: [
                  "Ideen und Verbesserungsvorschläge sind von jedem Mitglied gerne gesehen. Desweiteren hat jedes Mitglied das Recht, sich auf einen höheren Posten (Offizier, Raidoffizier) zu bewerben. Sollte der Bedarf bestehen, wird über die Annahme oder Ablehung entschieden.",
                ],
              },
            ],
          },
          {
            paragraph: "§12 Akzeptieren der Regeln / Änderungen",
            passages: [
              {
                passageHeadline: "",
                rules: [
                  "Jedes neue Mitglied erkennt mit dem Eintritt unsere Regeln an. Wir erwarten, dass jeder sich immer mal wieder die Regeln durchliest, um eventuelle Änderungen zur Kenntnis zu nehmen. Die Gildenleitung behält sich vor, bestehende Regeln zu ändern.",
                  "Sollte ein Mitglied die Regeln nicht akzeptieren oder dagegen verstoßen kann dies zum sofortigen Ausschluss führen!",
                  "Die Gildenleitung berät sich bei einem Regelverstoß mit den (Raid)Offizieren. Die Ahndung des Regelverstoßes und die Konsequenz wird dann gemeinschaftlich beschlossen.",
                ],
              },
            ],
          },
        ] as GuildRule[],
      };
    },
  };
</script>
