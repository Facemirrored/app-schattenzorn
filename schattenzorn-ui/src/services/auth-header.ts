import { HeaderAuth } from "@/store/auth/interfaces";

export default function authHeader() {
  const storedUser = localStorage.getItem("AuthState");
  const authState = JSON.parse(storedUser ? storedUser : "") as HeaderAuth;

  if (authState && authState.token) {
    return { Authorization: "Bearer " + authState.token };
  } else {
    return undefined;
  }
}
