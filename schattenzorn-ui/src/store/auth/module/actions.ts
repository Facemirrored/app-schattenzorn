import { ActionTypes } from "@/store/auth/types/action-types";
import { MutationTypes } from "@/store/auth/types/mutation-types";
import {
  AuthStateTypes,
  SignInRequest,
  SignUpRequest,
  SignUpStatus,
  SignUpResponse,
  User,
  HeaderAuth,
} from "@/store/auth/interfaces";
import { ActionContext, ActionTree } from "vuex";
import { Mutations } from "@/store/auth/module/mutations";
import { IRootState } from "@/store/interfaces";
import AuthService from "@/services/AuthService";
import { userSession } from "@/services/auth-header";

type AugmentedActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1],
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<AuthStateTypes, IRootState>, "commit">;

export interface Actions {
  [ActionTypes.LOAD_COOKIE_USER]({ commit }: AugmentedActionContext): void;
  [ActionTypes.SIGN_UP](
    { commit }: AugmentedActionContext,
    payload: SignUpRequest,
  ): Promise<SignUpResponse>;

  [ActionTypes.SIGN_IN](
    { commit }: AugmentedActionContext,
    payload: SignInRequest,
  ): Promise<void>;

  [ActionTypes.LOGOUT]({ commit }: AugmentedActionContext): void;
}

export const actions: ActionTree<AuthStateTypes, IRootState> & Actions = {
  [ActionTypes.LOAD_COOKIE_USER]({ commit }) {
    const headerAuth: HeaderAuth | undefined = userSession();
    if (headerAuth) {
      commit(MutationTypes.SET_USER, headerAuth);
    }
  },
  [ActionTypes.SIGN_UP]({ commit }, payload: SignUpRequest) {
    return AuthService.register(payload)
      .then((signUpStatus: SignUpResponse) => {
        if (signUpStatus.signupStatus === SignUpStatus.SUCCESS) {
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
  [ActionTypes.SIGN_IN]({ commit }, payload: SignInRequest) {
    return AuthService.login(payload)
      .then((data) => {
        commit(MutationTypes.LOGIN_SUCCESS, data);
        return Promise.resolve();
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
