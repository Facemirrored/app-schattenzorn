// initial state
import { UserState } from "@/store/user/interfaces";
import { VuexModule } from "vuex-module-decorators";
import { Mutations } from "@/store/auth/module/mutations";
import { CommitOptions, DispatchOptions, Module } from "vuex";
import { Getters } from "@/store/auth/module/getters";
import { Actions } from "@/store/auth/module/actions";
import { IRootState } from "@/store/interfaces";
import { getters } from "@/store/user/module/getters";
import { mutations } from "@/store/user/module/mutations";
import { actions } from "@/store/user/module/actions";

export const state: UserState = {
  user: undefined,
  characters: [],
};

export type Store<S = UserState> = Omit<
  VuexModule<S>,
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

export const UserModule: Module<UserState, IRootState> = {
  state,
  mutations,
  actions,
  getters,
};
