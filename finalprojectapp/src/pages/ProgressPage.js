import React, {useState} from "react";
import { Bar } from 'react-chartjs-2';
import { useEffect } from 'react';
import axios from "axios";
import {Chart as ChartJS} from 'chart.js/auto';


function ProgressPage(chartData) {

 
/*
useEffect(() => {
  FetchQuestionsRatingTotal();
}, []);
*/



  return (
    <div>
      
     { 
     <Bar data={chartData} /> 
     }


    </div>
    
  );
}

export default ProgressPage;