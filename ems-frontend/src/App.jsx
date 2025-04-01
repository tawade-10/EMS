import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import EmployeeComponent from "./Components/EmployeeComponent/EmployeeComponent";
import Footer from "./Components/Footer/Footer";
import Header from "./Components/Header/Header";
import ListEmployees from "./Components/ListEmployees/ListEmployees";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<ListEmployees />}></Route>
          <Route path="/employees" element={<ListEmployees />}></Route>
          <Route path="/add-employee" element={<EmployeeComponent />}></Route>
          <Route path="/edit-employee/:id" element={<EmployeeComponent />}></Route>
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
