import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Home() {
  const [heroes, setHeroes] = useState([]);

  useEffect(() => {
    loadHeroes();
  }, []);

  const loadHeroes = async () => {
    const result = await axios.get("http://localhost:8080/heroes");
    setHeroes(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border light">
          <thead className="table-dark">
            <tr>
              <th scope="col">Number</th>
              <th scope="col">Hero</th>
              <th scope="col">Level</th>
              <th scope="col">Gold</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody className="table-light">
            {heroes.map((hero, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{hero.name}</td>
                <td>{hero.level}</td>
                <td>{hero.gold}</td>
                <td>
                  <button className="btn btn-outline-info mx-2">View</button>
                  <button className="btn btn-primary mx-2">Edit</button>
                  <button className="btn btn-danger mx-2">Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
