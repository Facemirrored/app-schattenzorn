import { createStore } from "vuex";

import Auth from "./auth/auth.module";

export const store = createStore({
  modules: {
    Auth,
  },
});
