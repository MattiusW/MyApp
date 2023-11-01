import React from "react";

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <a className="navbar-brand" href="#">
            Hero
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toogle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <snap className="navbar-toggler-icon"></snap>
          </button>
          <button className="btn btn-outline-primary">Add Hero</button>
        </div>
      </nav>
    </div>
  );
}
