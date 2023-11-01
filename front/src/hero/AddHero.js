import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddHero() {

    let navigate = useNavigate();

    const [hero, setHero] = useState({
      name:""
    });

    const{name}=hero

    const onInputChange=(e)=>{
      setHero({...hero, [e.target.name]:e.target.value})
    }

    const onSubmit= async (e)=>{
      e.preventDefault();
      await axios.post("http://localhost:8080/hero", hero)
      navigate("/");
    }

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Hero name</h2>
          <form onSubmit={(e) =>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              State hero name
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your name"
              name="name"
              value={name}
              onChange={(e) => onInputChange(e)}
            />
          </div>
          <button type="submit" className="btn btn-success mx-1">
            Submit
          </button>
          <Link className="btn btn-danger mx-1" to="/">
            Cancel
          </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
