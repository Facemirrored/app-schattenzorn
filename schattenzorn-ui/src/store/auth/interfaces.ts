export type AuthStateTypes = {
  user?: User;
  loggedIn: boolean;
};

export type User = {
  username: string;
  password: string;
  email: string;
  token: string;
};

export type SignUpStatus = {
  signupState: SignUpState;
};

export enum SignUpState {
  SUCCESS = "SUCCESS",
  FAILED_EMAIL_TAKEN = "FAILED_EMAIL_TAKEN",
  FAILED_USERNAME_TAKEN = "FAILED_USERNAME_TAKEN",
}
