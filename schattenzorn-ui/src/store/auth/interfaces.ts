export type AuthStateTypes = {
  user?: User;
  token: string;
  loggedIn: boolean;
};

export type User = {
  username: string;
  password: string;
  email: string;
};
