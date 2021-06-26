export interface ContentSlotItem {
  headline: string;
  subHeadline: string;
  contentItems: ContentPartItem[];
}

export interface ContentPartItem {
  itemHeadline: string;
  itemTextList: string[];
}

export interface GuildRule {
  paragraph: string;
  passages: Passage[];
}

export interface Passage {
  passageHeadline: string;
  rules: string[];
  list: boolean;
}
