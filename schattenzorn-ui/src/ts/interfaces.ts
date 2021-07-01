export interface GuildRule {
  paragraph: string;
  passages: Passage[];
}

export interface Passage {
  passageHeadline: string;
  rules: string[];
  list: boolean;
}

export interface NewsSlotItem {
  title: string;
  content: string;
  date: string;
}

export enum LocalStorageAttribute {
  AUTH_STATE = "AUTH_STATE",
  LOGGED_IN = "LOGGED_IN",
}
