import { MutationTypes } from "@/store/auth/types/mutation-types";
import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { MutationTree } from "vuex";

export type Mutations<S = AuthStateTypes> = {
  [MutationTypes.SET_USER](state: S, payload: User): void;
};

export const mutations: MutationTree<AuthStateTypes> & Mutations = {
  [MutationTypes.SET_USER](state, payload: User) {
    state.user = payload;
  },
};
