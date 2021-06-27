import axios from "axios";
import { SignUpStatus, User } from "@/store/auth/interfaces";

const API_URL = "http://localhost:8080/api/auth";

class AuthService {
  login(username: string, password: string) {
    return axios
      .post(API_URL + "signIn", {
        username,
        password,
      })
      .then((response) => {
        if (response.data.token) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }
        return Promise.resolve(response.data as User);
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(user: User) {
    return axios
      .post(API_URL + "signUp", {
        username: user.username,
        email: user.email,
        password: user.password,
      })
      .then((response) => {
        return Promise.resolve(response.data as SignUpStatus);
      });
  }
}

export default new AuthService();
