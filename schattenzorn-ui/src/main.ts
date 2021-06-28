import { createApp } from "vue";
import App from "./App.vue";
import router from "@/router/router";
import { state } from "@/store";

const app = createApp(App).use(router).use(state).mount("#app");
