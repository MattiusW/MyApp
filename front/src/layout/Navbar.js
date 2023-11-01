import React from "react";
import { Link } from "react-router-dom";

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
          <Link className="btn btn-success" to="/addhero">Add Hero</Link>
        </div>
      </nav>
    </div>
  );
}
