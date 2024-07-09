import React from "react";
import { BrowserRouter,Routes,Route } from "react-router-dom";
import Address from "./Address";
import AdminProfile from "./AdminProfie";
import BankDetails from "./BankDetails"
import Experience from "./Experience"
import PersonalDetails from "./PersonalDetails"
import Qualifications from "./Qualifications";
import Router from "./Router"
function App() {
  return (
 <BrowserRouter>
 <Routes>
<Route path="/" Component={AdminProfile}/>
<Route path="/add" Component={Address}/>
<Route path="/bank" Component={BankDetails}/>
<Route path="/exp" Component={Experience}/>
<Route path="/per" Component={PersonalDetails}/>
<Route path="/quil" Component={Qualifications}/>
<Route path="/ro" Component={Router}/>
 </Routes>
 </BrowserRouter>
  );
}

export default App;
