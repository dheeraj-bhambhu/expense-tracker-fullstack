import { useNavigate } from "react-router-dom";

function Dashboard() {

  const navigate = useNavigate();

  function handleLogout() {

    localStorage.removeItem("token");

    navigate("/");

  }

  return (
    <div className="min-h-screen flex flex-col justify-center items-center bg-gray-100">

      <h1 className="text-4xl font-bold mb-6">
        Dashboard
      </h1>

      <button
        onClick={handleLogout}
        className="bg-red-600 text-white px-6 py-3 rounded-lg"
      >
        Logout
      </button>

    </div>
  );
}

export default Dashboard;