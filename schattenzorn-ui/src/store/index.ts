import { createStore } from "vuex";
import { AuthModule } from "@/store/auth/module/auth.module";
import { UserModule } from "@/store/user/module/user.module";

export const state = createStore({
  modules: {
    AuthModule,
    UserModule,
  },
});

export type State = typeof state;
