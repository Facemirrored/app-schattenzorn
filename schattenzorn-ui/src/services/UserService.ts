import axios from "axios";
import { authHeader } from "@/services/auth-header";
import { LoadProfileResponse } from "@/store/auth/interfaces";

const API_URL = import.meta.env.PROD
  ? "https://app-schattenzorn-test.herokuapp.com/api/test/"
  : "http://localhost:8080/api/user/";

class UserService {
  loadProfile(): Promise<LoadProfileResponse> {
    return axios
      .get(API_URL + "getUser", {
        headers: authHeader(),
      })
      .then((response) => {
        return Promise.resolve(response.data as LoadProfileResponse);
      });
  }
}

export default new UserService();
