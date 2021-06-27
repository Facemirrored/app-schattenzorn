import { MutationTypes } from "@/store/auth/types/mutation-types";
import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { MutationTree } from "vuex";

export type Mutations<S = AuthStateTypes> = {
  [MutationTypes.SET_USER](state: S, payload: User): void;
  [MutationTypes.LOGIN_SUCCESS](state: S, payload: User): void;
  [MutationTypes.LOGIN_FAILURE](state: S): void;
  [MutationTypes.LOGOUT](state: S): void;
  [MutationTypes.REGISTER_SUCCESS](state: S): void;
  [MutationTypes.REGISTER_FAILURE](state: S): void;
};

export const mutations: MutationTree<AuthStateTypes> & Mutations = {
  [MutationTypes.SET_USER](state, payload: User) {
    state.user = payload;
  },
  [MutationTypes.LOGIN_SUCCESS](state, payload) {
    state.user = payload;
    state.loggedIn = true;
  },
  [MutationTypes.LOGIN_FAILURE](state) {
    state.loggedIn = false;
  },
  [MutationTypes.LOGOUT](state) {
    state.user = undefined;
    state.loggedIn = false;
  },
  [MutationTypes.REGISTER_SUCCESS](state) {
    state.loggedIn = false;
  },
  [MutationTypes.REGISTER_FAILURE](state) {
    state.loggedIn = false;
  },
};
