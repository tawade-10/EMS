import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./ListEmployee.css";

const ListEmployees = () => {
  const [employees, setEmployees] = useState([]);
  const navigator = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  function getAllEmployees() {
    const fetchEmployees = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/employees");
        setEmployees(response.data);
      } catch (error) {
        console.error("Error fetching employees:", error);
        alert("Failed to fetch employees. Please check the console.");
      }
    };

    fetchEmployees();
  }

  function addNewEmployee() {
    navigator("/add-employee");
  }

  function updateEmployee(employeeId) {
    navigator(`/edit-employee/${employeeId}`);
  }

  function deleteEmployee(id) {
    axios
      .delete(`http://localhost:8080/api/employees/${id}`)
      .then(() => {
        getAllEmployees();
      })
      .catch((error) => {
        console.error("Error deleting employee:", error);
        alert("Failed to delete employee. Please check the console.");
      });
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateEmployee(employee.id)}
                >
                  Update
                </button>
              </td>
              <td>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteEmployee(employee.id)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployees;
