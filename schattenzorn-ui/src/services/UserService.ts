import axios from "axios";
import { authHeader } from "@/services/auth-header";
import {
  AddCharacterRequest,
  AddCharacterResponse,
  LoadProfileResponse,
  AddCharacterResponseStatus,
} from "@/store/interfaces";
import { Character } from "@/store/user/interfaces";

const API_URL = import.meta.env.PROD
  ? "https://app-schattenzorn-test.herokuapp.com/api/test/"
  : "http://localhost:8080/api/user/";

class UserService {
  addCharacter(
    addCharacterRequest: AddCharacterRequest,
  ): Promise<AddCharacterResponse> {
    // TODO: backend call + frontend validation
    return Promise.resolve({
      character: {
        characterName: "neuer char",
        male: true,
        level: 44,
        notes: "JAM MAN!",
      } as Character,
      status: AddCharacterResponseStatus.SUCCESS,
    } as AddCharacterResponse);
  }
  loadProfile(): Promise<LoadProfileResponse> {
    return axios
      .get(API_URL + "getProfile", {
        headers: authHeader(),
      })
      .then((response) => {
        return Promise.resolve(response.data as LoadProfileResponse);
      });
  }
}

export default new UserService();
