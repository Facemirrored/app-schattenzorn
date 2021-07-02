import { MutationTypes } from "@/store/auth/types/mutation-types";
import { AuthState } from "@/store/auth/interfaces";
import { MutationTree } from "vuex";
import { SignInResponse } from "@/store/interfaces";

export type Mutations<S = AuthState> = {
  [MutationTypes.LOGIN_SUCCESS](state: S, payload: SignInResponse): void;
  [MutationTypes.LOGIN_FAILURE](state: S): void;
  [MutationTypes.LOGOUT](state: S): void;
  [MutationTypes.REGISTER_SUCCESS](state: S): void;
  [MutationTypes.REGISTER_FAILURE](state: S): void;
};

export const mutations: MutationTree<AuthState> & Mutations = {
  [MutationTypes.LOGIN_SUCCESS](state, payload) {
    state.token = payload.token;
    state.loggedIn = true;
  },
  [MutationTypes.LOGIN_FAILURE](state) {
    state.loggedIn = false;
  },
  [MutationTypes.LOGOUT](state) {
    state.token = "";
    state.loggedIn = false;
  },
  [MutationTypes.REGISTER_SUCCESS](state) {
    state.loggedIn = false;
  },
  [MutationTypes.REGISTER_FAILURE](state) {
    state.loggedIn = false;
  },
};
