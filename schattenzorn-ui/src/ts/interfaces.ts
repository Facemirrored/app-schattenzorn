export interface ContentSlotItem {
  headline: string;
  subHeadline: string;
  contentItems: ContentPartItem[];
}

export interface ContentPartItem {
  itemHeadline: string;
  itemTextList: string[];
}
