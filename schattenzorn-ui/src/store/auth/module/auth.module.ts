import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { CommitOptions, DispatchOptions, Module } from "vuex";
import { IRootState } from "@/store/interfaces";
import { Mutations, mutations } from "@/store/auth/module/mutations";
import { Actions, actions } from "@/store/auth/module/actions";
import { Getters, getters } from "@/store/auth/module/getters";
import { Store as VuexStore } from "vuex";

// initial state
export const state: AuthStateTypes = {
  user: undefined,
  loggedIn: false,
  token: "",
};

export type Store<S = AuthStateTypes> = Omit<
  VuexStore<S>,
  "commit" | "getters" | "dispatch"
> & {
  commit<K extends keyof Mutations, P extends Parameters<Mutations[K]>[1]>(
    key: K,
    payload: P,
    options?: CommitOptions,
  ): ReturnType<Mutations[K]>;
} & {
  getters: {
    [K in keyof Getters]: ReturnType<Getters[K]>;
  };
} & {
  dispatch<K extends keyof Actions>(
    key: K,
    payload: Parameters<Actions[K]>[1],
    options?: DispatchOptions,
  ): ReturnType<Actions[K]>;
};

export const AuthModule: Module<AuthStateTypes, IRootState> = {
  state,
  mutations,
  actions,
  getters,
};
