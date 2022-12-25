import './App.css';
import React, {useState, useEffect} from "react";
import DatePicker from "react-datepicker";
import axios from 'axios';

import "react-datepicker/dist/react-datepicker.css";
import FormPage from './pages/FormPage';
import ProgressPage from './pages/ProgressPage';
import { HeartSwitch } from "@anatoliygatt/heart-switch";




function App() {

    const [user, setUser] = useState([]);
    const [totals, setTotals] = useState([]);
    const [checked, setChecked] = useState(false);

    const FetchUser = () => {

    axios.get("http://localhost:8081/api/users/1")
        .then(res => {
            console.log(res.data)
            setUser(res.data);
          }).catch(err =>console.log(err))
        }

     
        
       
/*
    const [userData, setUserData] = useState({
      labels : ['2022-12-10', '2022-12-03'],
      datasets: [{
        label: "Ratings",
        data: totals.map((data) => data.ratingTotal),
      }]
    })


    
      const GetProgress = () => {
        axios.get("http://localhost:8081/api/users/1/questionsRatingTotal")
      .then(reponse => {
          //console.log(isNew);
          console.log(reponse.data)
          setTotals(reponse.data);
          }).catch(err =>console.log(err))
      }
*/

    
  
 

   
  return (
    <div className="App">
    <HeartSwitch
      size="lg"
      inactiveTrackFillColor="#cffafe"
      inactiveTrackStrokeColor="#22d3ee"
      activeTrackFillColor="#06b6d4"
      activeTrackStrokeColor="#0891b2"
      inactiveThumbColor="#ecfeff"
      activeThumbColor="red"
      checked={checked}
      onChange={(event) => {
        setChecked(event.target.checked);
      }}
      
    />
    
   

        <h1>MOOD PICKER</h1>

        <h2>Hello {user && (user.username)} choose your option.</h2>
        <button >Your Progress</button>
        
        <button /*</div>onClick={() =>
        history.push("/FormPage")
        }*/>Mood Picker</button>  
        
        <FormPage></FormPage>
  
    
    </div>
  );
}

export default App;