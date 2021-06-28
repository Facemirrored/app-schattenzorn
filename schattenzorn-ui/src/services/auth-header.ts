import { HeaderAuth, User } from "@/store/auth/interfaces";
import { getCookie } from "@/ts/cookie-typescript-utils";
import { Cookies } from "@/ts/interfaces";

function getHeader(): HeaderAuth | undefined {
  const storedUser = getCookie(Cookies.AUTH_STATE);
  if (storedUser) {
    return JSON.parse(storedUser) as HeaderAuth;
  }
  return undefined;
}

export function authHeader(): unknown | undefined {
  const authState = getHeader();

  if (authState && authState.token) {
    return { Authorization: "Bearer " + authState.token };
  }
  return undefined;
}

export function userSession(): HeaderAuth | undefined {
  const authState = getHeader();

  if (authState && authState) {
    return authState;
  }
  return undefined;
}
