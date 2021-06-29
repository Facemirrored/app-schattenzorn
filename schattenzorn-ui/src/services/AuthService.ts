import axios from "axios";
import {
  SignInRequest,
  SignInResponse,
  SignInStatus,
  SignUpRequest,
  SignUpResponse,
} from "@/store/auth/interfaces";
import { deleteCookie, setCookie } from "@/ts/cookie-typescript-utils";
import { Cookies } from "@/ts/interfaces";

const API_URL = import.meta.env.PROD
  ? "https://app-schattenzorn-test.herokuapp.com/api/auth"
  : "http://localhost:8080/api/auth";

class AuthService {
  login(signInRequest: SignInRequest) {
    return axios
      .post(API_URL + "/signIn", {
        username: signInRequest.username,
        password: signInRequest.password,
      })
      .then((response) => {
        return Promise.resolve(response.data as SignInResponse);
      });
  }

  logout() {
    deleteCookie(Cookies.AUTH_STATE);
  }

  register(signUpRequest: SignUpRequest) {
    return axios
      .post(API_URL + "/signUp", {
        username: signUpRequest.username,
        password: signUpRequest.password,
        email: signUpRequest.email,
      })
      .then((response) => {
        return Promise.resolve(response.data as SignUpResponse);
      });
  }
}

export default new AuthService();
