import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddHero from "./hero/AddHero";
import EditHero from "./hero/EditHero";
import ViewHero from "./hero/ViewHero";


function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addhero" element={<AddHero/>} />
          <Route exact path="/edithero/:id" element={<EditHero/>}/>
          <Route exact path="/viewhero/:id" element={<ViewHero />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
