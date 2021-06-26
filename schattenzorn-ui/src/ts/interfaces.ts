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
