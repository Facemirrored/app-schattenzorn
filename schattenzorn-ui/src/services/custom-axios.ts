import axios from "axios";

const COOKIES = document.cookie.match(new RegExp(`XSRF-TOKEN=([^;]+)`));
const CSRF_TOKEN = COOKIES ? COOKIES[1] : undefined;
const instance = axios.create({
  headers: { "X-XSRF-TOKEN": CSRF_TOKEN },
});
export const AXIOS = instance;
