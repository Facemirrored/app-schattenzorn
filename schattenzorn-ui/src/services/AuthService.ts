import axios from "axios";
import {
  SignInRequest,
  SignInResponse,
  SignUpRequest,
  SignUpResponse,
  User,
} from "@/store/auth/interfaces";

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
          localStorage.setItem("AuthState", JSON.stringify(response.data));
        }
        return Promise.resolve(response.data as SignInResponse);
      });
  }

  logout() {
    localStorage.removeItem("AuthState");
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
