import { createStore, Store } from "vuex";
import { AuthModule } from "@/store/auth/module/auth.module";
import { IRootState } from "@/store/interfaces";

export const state = createStore({
  modules: {
    AuthModule,
  },
});

export type State = typeof state;
