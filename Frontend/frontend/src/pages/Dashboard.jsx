import { useEffect, useState } from "react";
import { getDashboard } from "../api/dashboard";
import { Bar } from "react-chartjs-2";
import "./Dashboard.css";

export default function Dashboard() {
  const [data, setData] = useState(null);

  useEffect(() => {
    getDashboard()
      .then(res => setData(res.data))
      .catch(err => console.log(err));
  }, []);

  if (!data) return <h2>Loading...</h2>;

  const chartData = {
    labels: ["Completed", "Pending"],
    datasets: [
      {
        label: "Tasks",
        data: [data.completedTasks, data.pendingTasks],
      },
    ],
  };

  return (
    <div className="dashboard">

      <h1>📊 Dashboard</h1>

      {/* 🔹 STATS */}
      <div className="cards">
        <div className="card green">
          <h3>Total Projects</h3>
          <p>{data.totalProjects}</p>
        </div>

        <div className="card blue">
          <h3>Total Tasks</h3>
          <p>{data.totalTasks}</p>
        </div>

        <div className="card purple">
          <h3>Completed</h3>
          <p>{data.completedTasks}</p>
        </div>

        <div className="card orange">
          <h3>Pending</h3>
          <p>{data.pendingTasks}</p>
        </div>
      </div>

      {/* 🔹 CHART */}
      <div className="chart-container">
        <Bar data={chartData} />
      </div>

    </div>
  );
}