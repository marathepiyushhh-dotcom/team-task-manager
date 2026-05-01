import { useState } from "react";
import api from "../api/axios";

function Login({ setToken, setShowLogin }) {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {
    const res = await api.post("/auth/login", { email, password });
    localStorage.setItem("token", res.data.token);
    setToken(res.data.token);
  };

  return (
    <div>
      <h2>Team Task Manager - Login</h2>

      <input
        placeholder="Email"
        onChange={(e) => setEmail(e.target.value)}
      />

      <input
        placeholder="Password"
        type="password"
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={login}>Login</button>

      <p>
  Don't have an account?{" "}
  <button onClick={() => setShowLogin(false)}>Register</button>
</p>

    </div>

    
  );
}

export default Login;