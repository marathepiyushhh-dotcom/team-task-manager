import { useState } from "react";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";

function App() {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [showLogin, setShowLogin] = useState(true);

  if (token) return <Dashboard token={token} />;

  return showLogin ? (
    <Login setToken={setToken} setShowLogin={setShowLogin} />
  ) : (
    <Register setShowLogin={setShowLogin} />
  );
}

export default App;