import { Character, UserState } from "@/store/user/interfaces";
import { MutationTypes } from "@/store/user/types/mutation-types";
import { LoadProfileResponse } from "@/store/interfaces";
import { MutationTree } from "vuex";

export type Mutations<S = UserState> = {
  [MutationTypes.SET_PROFILE_DATA](
    state: S,
    payload: LoadProfileResponse,
  ): void;
  [MutationTypes.CLEAR_PROFILE_DATA](state: S): void;
  [MutationTypes.ADD_Character](state: S, payload: Character): void;
};

export const mutations: MutationTree<UserState> & Mutations = {
  [MutationTypes.SET_PROFILE_DATA](state, payload) {
    state.user = payload.user;
    state.characters = payload.characters;
  },
  [MutationTypes.CLEAR_PROFILE_DATA](state) {
    state.user = undefined;
    state.characters = [];
  },
  [MutationTypes.ADD_Character](state, payload) {
    state.characters.push(payload);
  },
};
