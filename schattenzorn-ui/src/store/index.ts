import { createStore } from "vuex";
import { AuthModule } from "@/store/auth/module/auth.module";

export const state = createStore({
  modules: {
    AuthModule,
  },
});

export type State = typeof state;
