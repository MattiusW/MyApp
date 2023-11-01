import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

export default function EditHero() {

    let navigate = useNavigate();

    const {id}=useParams();

    const [hero, setHero] = useState({
      name:""
    });

    const{name}=hero;

    const onInputChange=(e)=>{
      setHero({...hero, [e.target.name]:e.target.value});
    };

    useEffect(()=>{
        loadHero()
    }, []);

    const onSubmit= async (e)=>{
      e.preventDefault();
      await axios.put(`http://localhost:8080/hero/${id}`, hero);
      navigate("/");
    };

    const loadHero = async () => {
        const result = await axios.get(`http://localhost:8080/hero/${id}`)
        setHero(result.data)
    }

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Edit Hero</h2>
          <form onSubmit={(e) =>onSubmit(e)}>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              Edit hero name
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter hero name"
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
