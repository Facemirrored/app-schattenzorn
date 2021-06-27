import { Mutation } from "vuex";

export interface MutationTree<S> {
  [key: string]: Mutation<S>;
}
