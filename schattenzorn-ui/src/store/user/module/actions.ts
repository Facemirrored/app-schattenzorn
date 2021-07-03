import { ActionContext, ActionTree } from "vuex";
import {
  AddCharacterRequest,
  AddCharacterResponse,
  SignInResponseStatus,
  IRootState,
  LoadProfileResponse,
  AddCharacterResponseStatus,
} from "@/store/interfaces";
import { UserState } from "@/store/user/interfaces";
import { ActionTypes } from "@/store/user/types/action-types";
import { MutationTypes } from "@/store/user/types/mutation-types";
import { Mutations } from "@/store/user/module/mutations";
import UserService from "@/services/UserService";

type AugmentedActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1],
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<UserState, IRootState>, "commit">;

export interface Actions {
  [ActionTypes.LOAD_PROFILE]({
    commit,
  }: AugmentedActionContext): Promise<LoadProfileResponse>;
  [ActionTypes.REMOVE_PROFILE]({
    commit,
  }: AugmentedActionContext): Promise<void>;
  [ActionTypes.ADD_CHARACTER](
    { commit }: AugmentedActionContext,
    payload: AddCharacterRequest,
  ): Promise<AddCharacterResponse>;
}

export const actions: ActionTree<UserState, IRootState> & Actions = {
  [ActionTypes.LOAD_PROFILE]({ commit }) {
    return UserService.loadProfile()
      .then((loadProfileResponse) => {
        commit(MutationTypes.SET_PROFILE_DATA, loadProfileResponse);
        return Promise.resolve(loadProfileResponse);
      })
      .catch((error) => Promise.reject(error));
  },
  [ActionTypes.REMOVE_PROFILE]({ commit }) {
    commit(MutationTypes.CLEAR_PROFILE_DATA, undefined);
    return Promise.resolve();
  },
  [ActionTypes.ADD_CHARACTER]({ commit }, payload: AddCharacterRequest) {
    return UserService.addCharacter(payload)
      .then((addCharacterResponse) => {
        if (
          addCharacterResponse.status === AddCharacterResponseStatus.SUCCESS
        ) {
          commit(MutationTypes.ADD_Character, addCharacterResponse.character);
        }
        return Promise.resolve(addCharacterResponse);
      })
      .catch((error) => Promise.reject(error));
  },
};
