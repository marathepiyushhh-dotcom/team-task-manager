import { useState } from "react";
import api from "../api/axios";

function Register({ setShowLogin }) {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const register = async () => {
    try {
      await api.post("/auth/register", { name, email, password });
      alert("Registered successfully! Now login.");
      setShowLogin(true);
    } catch (err) {
      alert("Error registering");
    }
  };

  return (
    <div>
      <h2>Team Task Manager - Register</h2>

      <input placeholder="Name" onChange={(e) => setName(e.target.value)} />
      <input placeholder="Email" onChange={(e) => setEmail(e.target.value)} />
      <input placeholder="Password" type="password" onChange={(e) => setPassword(e.target.value)} />

      <button onClick={register}>Register</button>

      <p>
        Already have an account?{" "}
        <button onClick={() => setShowLogin(true)}>Login</button>
      </p>
    </div>
  );
}

export default Register;