import React from "react";

export default function AddHero() {
  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Hero name</h2>
          <div className="mb-3">
            <label htmlFor="Name" className="form-label">
              State hero name
            </label>
            <input
              type={"text"}
              className="form-control"
              placeholder="Enter your name"
              name="name"
            />
          </div>
          <button type="submit" className="btn btn-success mx-1">
            Submit
          </button>
          <button type="submit" className="btn btn-danger mx-1">
            Cancel
          </button>
        </div>
      </div>
    </div>
  );
}
