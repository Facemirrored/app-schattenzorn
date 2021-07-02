import { AuthState } from "@/store/auth/interfaces";
import { GetterTree } from "vuex";
import { IRootState } from "@/store/interfaces";

export type Getters = {
  getLoginStatus(state: AuthState): boolean;
};

export const getters: GetterTree<AuthState, IRootState> & Getters = {
  getLoginStatus: (state) => state.loggedIn,
};
