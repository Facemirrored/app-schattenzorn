export type AuthStateTypes = {
  user?: User;
  token: string;
  loggedIn: boolean;
};

export type HeaderAuth = {
  user: User;
  token: string;
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

export type SignInRequest = {
  username: string;
  password: string;
};

export type SignInResponse = {
  user: User;
  token: string;
};

export type SignUpRequest = {
  username: string;
  email: string;
  password: string;
};

export type SignUpResponse = {
  signupStatus: SignUpStatus;
};

export enum SignUpStatus {
  SUCCESS = "SUCCESS",
  FAILED_EMAIL_TAKEN = "FAILED_EMAIL_TAKEN",
  FAILED_USERNAME_TAKEN = "FAILED_USERNAME_TAKEN",
}
