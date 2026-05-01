import { useEffect, useState } from "react";
import api from "../api/axios";

function Dashboard({ token }) {
  const [projects, setProjects] = useState([]);
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");

  const fetchProjects = async () => {
    const res = await api.get("/projects", {
      headers: { Authorization: `Bearer ${token}` },
    });
    setProjects(res.data);
  };

  const createProject = async () => {
    await api.post(
      "/projects",
      { name, description },
      { headers: { Authorization: `Bearer ${token}` } }
    );
    fetchProjects();
  };

  useEffect(() => {
    fetchProjects();
  }, []);

  return (
    <div>
      <h2>Team Task Manager</h2>

      <input
        placeholder="Project Name"
        onChange={(e) => setName(e.target.value)}
      />

      <input
        placeholder="Description"
        onChange={(e) => setDescription(e.target.value)}
      />

      <button onClick={createProject}>Create Project</button>

      <h3>Projects</h3>
      <ul>
        {projects.map((p) => (
          <li key={p.id}>
            {p.name} - {p.description}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Dashboard;