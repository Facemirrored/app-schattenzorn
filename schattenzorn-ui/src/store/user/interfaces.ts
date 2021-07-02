export type UserState = {
  user?: User;
  characters: Character[];
};

export type Character = {
  characterName: string;
  male: boolean;
  level: number;
  notes: string;
};

export type User = {
  username: string;
  email: string;
  roles: Roles[];
};

export enum Roles {
  ROLE_USER = "ROLE_USER",
  ROLE_MODERATOR = "ROLE_MODERATOR",
  ROLE_ADMIN = "ROLE_ADMIN",
}
