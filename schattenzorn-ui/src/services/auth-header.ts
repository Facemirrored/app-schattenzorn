import { HeaderAuth } from "@/store/auth/interfaces";
import { LocalStorageAttribute } from "@/ts/interfaces";

function getHeader(): HeaderAuth | undefined {
  const storedToken = localStorage.getItem(LocalStorageAttribute.AUTH_STATE);
  if (storedToken) {
    return JSON.parse(storedToken) as HeaderAuth;
  }
  return undefined;
}

export function authHeader(): unknown | undefined {
  const authState = getHeader();

  if (authState) {
    return { Authorization: "Bearer " + authState };
  }
  return undefined;
}
