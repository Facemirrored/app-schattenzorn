import { ActionTypes } from "@/store/auth/types/action-types";
import { MutationTypes } from "@/store/auth/types/mutation-types";
import { AuthStateTypes, User } from "@/store/auth/interfaces";
import { ActionContext, ActionTree } from "vuex";
import { Mutations } from "@/store/auth/module/mutations";
import { IRootState } from "@/store/interfaces";

type AugmentedActionContext = {
  commit<K extends keyof Mutations>(
    key: K,
    payload: Parameters<Mutations[K]>[1],
  ): ReturnType<Mutations[K]>;
} & Omit<ActionContext<AuthStateTypes, IRootState>, "commit">;

export interface Actions {
  [ActionTypes.REGISTER_USER](
    { commit }: AugmentedActionContext,
    payload: User,
  ): Promise<User>;
}

export const actions: ActionTree<AuthStateTypes, IRootState> & Actions = {
  [ActionTypes.REGISTER_USER]({ commit }) {
    return new Promise((resolve) => {
      // TODO: AXIOS CALL
      const data: User = {
        username: "lel",
        password: "lel",
        email: "lel",
      };
      commit(MutationTypes.SET_USER, data);
      resolve(data);
    });
  },
};
