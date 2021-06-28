import { MutationTypes } from "@/store/auth/types/mutation-types";
import { AuthStateTypes, SignInResponse } from "@/store/auth/interfaces";
import { MutationTree } from "vuex";

export type Mutations<S = AuthStateTypes> = {
  [MutationTypes.LOGIN_SUCCESS](state: S, payload: SignInResponse): void;
  [MutationTypes.LOGIN_FAILURE](state: S): void;
  [MutationTypes.LOGOUT](state: S): void;
  [MutationTypes.REGISTER_SUCCESS](state: S): void;
  [MutationTypes.REGISTER_FAILURE](state: S): void;
};

export const mutations: MutationTree<AuthStateTypes> & Mutations = {
  [MutationTypes.LOGIN_SUCCESS](state, payload) {
    state.user = payload.user;
    state.token = payload.token;
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
