import axios from "axios";
import {
  SignInRequest,
  SignInResponse,
  SignUpRequest,
  SignUpResponse,
} from "@/store/auth/interfaces";
import { deleteCookie, setCookie } from "@/ts/cookie-typescript-utils";
import { Cookies } from "@/ts/interfaces";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(signInRequest: SignInRequest) {
    return axios
      .post(API_URL + "signIn", {
        username: signInRequest.username,
        password: signInRequest.password,
      })
      .then((response) => {
        if (response.data.token) {
          setCookie(Cookies.AUTH_STATE, JSON.stringify(response.data));
        }
        return Promise.resolve(response.data as SignInResponse);
      });
  }

  logout() {
    deleteCookie(Cookies.AUTH_STATE);
  }

  register(signUpRequest: SignUpRequest) {
    return axios
      .post(API_URL + "signUp", {
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
