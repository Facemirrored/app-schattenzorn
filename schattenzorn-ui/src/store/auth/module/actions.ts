import { ActionTypes } from "@/store/auth/types/action-types";
import { MutationTypes } from "@/store/auth/types/mutation-types";
import {
  AuthStateTypes,
  SignUpState,
  SignUpStatus,
  User,
} from "@/store/auth/interfaces";
import { ActionContext, ActionTree } from "vuex";
import { Mutations } from "@/store/auth/module/mutations";
import { IRootState } from "@/store/interfaces";
import AuthService from "@/services/AuthService";

type AugmentedActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1],
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<AuthStateTypes, IRootState>, "commit">;

export interface Actions {
  [ActionTypes.SIGN_UP](
    { commit }: AugmentedActionContext,
    payload: User,
  ): Promise<SignUpStatus>;
  [ActionTypes.SIGN_IN](
    { commit }: AugmentedActionContext,
    payload: { username: string; password: string },
  ): Promise<User>;
  [ActionTypes.LOGOUT]({ commit }: AugmentedActionContext): void;
}

export const actions: ActionTree<AuthStateTypes, IRootState> & Actions = {
  [ActionTypes.SIGN_UP]({ commit }, payload: User) {
    return AuthService.register(payload)
      .then((signUpStatus: SignUpStatus) => {
        if (signUpStatus.signupState === SignUpState.SUCCESS) {
          commit(MutationTypes.REGISTER_SUCCESS, undefined);
        } else {
          commit(MutationTypes.REGISTER_FAILURE, undefined);
        }
        return Promise.resolve(signUpStatus);
      })
      .catch((error) => {
        console.log("error request sign up user: ", error);
        return Promise.reject(error);
      });
  },
  [ActionTypes.SIGN_IN](
    { commit },
    payload: { username: string; password: string },
  ) {
    return AuthService.login(payload.username, payload.password)
      .then((user) => {
        commit(MutationTypes.LOGIN_SUCCESS, user);
        return Promise.resolve(user);
      })
      .catch((error) => {
        console.log("error request login: ", error);
        return Promise.reject(error);
      });
  },
  [ActionTypes.LOGOUT]({ commit }) {
    AuthService.logout();
    commit(MutationTypes.LOGOUT, undefined);
  },
};
