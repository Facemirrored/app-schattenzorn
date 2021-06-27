import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { GetterTree } from "vuex";
import { IRootState } from "@/store/interfaces";

export type Getters = {
  getUser(state: AuthStateTypes): User | undefined;
};

export const getters: GetterTree<AuthStateTypes, IRootState> & Getters = {
  getUser: (state) => state.user,
};
