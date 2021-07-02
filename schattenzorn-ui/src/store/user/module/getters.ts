import { GetterTree } from "vuex";
import { Character, User, UserState } from "@/store/user/interfaces";
import { IRootState } from "@/store/interfaces";

export type Getters = {
  getUser(state: UserState): User | undefined;
  getCharacters(state: UserState): Character[];
};

export const getters: GetterTree<UserState, IRootState> & Getters = {
  getUser: (state) => state.user,
  getCharacters: (state) => (state.characters ? state.characters : []),
};
