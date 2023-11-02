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

    //Handle error if name is empty
    const onSubmit= async (e)=>{
      e.preventDefault();
      if (name.trim().length === 0){
        alert("Hero name cannot be empty!");
        return;
      }
      if(!name.trim().match(/^[a-zA-Z\s]+$/)){
        alert("Hero name can only contain letter and spaces!");
        return;
      }
      
      try{
        await axios.post("http://localhost:8080/hero", hero);
        navigate("/");
      }
      catch(error){
        if(error.response && error.response.status === 400){
          alert("Too many heroes! You can only have a three.");
        }
        else{
          console.error(error.message);
        }
      }

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
