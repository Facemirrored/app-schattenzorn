// eslint-disable-next-line @typescript-eslint/no-empty-interface
import { Character, User } from "@/store/user/interfaces";

// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface IRootState {}

export type SignInRequest = {
  username: string;
  password: string;
};

export type SignInResponse = {
  signInStatus: SignInResponseStatus;
  user: User;
  token: string;
};

export enum SignInResponseStatus {
  SUCCESS = "SUCCESS",
  FAILED = "FAILED",
}

export enum AddCharacterResponseStatus {
  SUCCESS = "SUCCES",
  USERNAME_TAKEN = "USERNAME_TAKEN",
}

export type SignUpRequest = {
  username: string;
  email: string;
  password: string;
  passwordRepeat?: string;
};

export type SignUpResponse = {
  signupStatus: SignUpStatus;
};

export enum SignUpStatus {
  SUCCESS = "SUCCESS",
  FAILED_EMAIL_TAKEN = "FAILED_EMAIL_TAKEN",
  FAILED_USERNAME_TAKEN = "FAILED_USERNAME_TAKEN",
}

export type AddCharacterResponse = {
  status: AddCharacterResponseStatus;
  character: Character;
};

export type AddCharacterRequest = {
  character: Character;
};

export type LoadProfileResponse = {
  user: User;
  characters: Character[];
};
