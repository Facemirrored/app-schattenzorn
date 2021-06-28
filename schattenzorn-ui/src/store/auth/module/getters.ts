import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { GetterTree } from "vuex";
import { IRootState } from "@/store/interfaces";

export type Getters = {
  getUser(state: AuthStateTypes): User | undefined;
  getLoginStatus(state: AuthStateTypes): boolean;
};

export const getters: GetterTree<AuthStateTypes, IRootState> & Getters = {
  getUser: (state) => state.user,
  getLoginStatus: (state) => state.loggedIn,
};
