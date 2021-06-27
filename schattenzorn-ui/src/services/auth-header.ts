import { User } from "@/store/auth/interfaces";

export default function authHeader() {
  const storedUser = localStorage.getItem("user");
  const user = JSON.parse(storedUser ? storedUser : "") as User;

  if (user && user.token) {
    return { Authorization: "User " + user.token };
  } else {
    return undefined;
  }
}
