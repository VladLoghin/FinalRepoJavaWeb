import axios from 'axios';
import { useEffect, useState } from 'react';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { RadioGroup, Radio } from 'react-radio-group';
import { Controller, useForm } from 'react-hook-form'



function FormPage() {
    const [questions, setQuestions] = useState([]);
    const [startDate, setStartDate] = useState("");
    let isNew = true;

    const { handleSubmit, register, reset, control } = useForm({  });

    const FetchQuestions = () => {
        axios.get("http://localhost:8081/api/questions")
        .then(res => {
            //console.log(isNew);
            console.log(res.data)
            setQuestions(res.data);
            }).catch(err =>console.log(err))
        };

    const FetchQuestionsRatings = (selectedDate) => {
        //const d = dateFormat(startDate);
        console.log(selectedDate);
        const params = new URLSearchParams([['date', dateFormat(selectedDate)]]);
        axios.get("http://localhost:8081/api/users/1/questions", {params})
        .then(res => {
            console.log(res.data); 

            setQuestions(res.data);
            //let m =(res.data.length==0);
            isNew = (res.data.length==0);
            if(isNew){
                FetchQuestions();
            }
           console.log(isNew + "/"+ res.data.length);
          }).catch(err =>console.log(err))
      };

    
    
    const addUserQuestionRating = (questions)=>{
            isNew = !(questions[0].id );
        console.log(questions)
        if(isNew){
            const toAddQuestions = questions.map(item => {
                const container = {};
    
                container["questionId"] = item.questionId;
                container.rating = item.rating;
    
                return container;
            })
            console.log(toAddQuestions);
            let d = dateFormat(startDate);
            let url = 'http://localhost:8081/api/users/1/questions?date=' + d;
            //const params = new URLSearchParams([['date', d]]);
            axios.post(url, toAddQuestions)
            .then(function (response){
                console.log(response);
                FetchQuestionsRatings(startDate);
            })
            .catch(function (error){
                console.log(error);
            });
           
        }
    else{
        const toUpdateQuestions = questions.map(item => {
            const container = {};

            container["id"] = item.id;
            container["userId"] = 1;
            container["questionId"] = item.questionId;
            container.rating = item.rating;

            return container;
        })
        console.log(toUpdateQuestions);
        let d = dateFormat(startDate);
        let url = 'http://localhost:8081/api/users/1/questions?date=' + d;
        axios.put(url, toUpdateQuestions)
        .then(function (response){
            console.log(response);
            FetchQuestionsRatings();
        })
        .catch(function (error){
            console.log(error);
        });
    }

        }  

        const deleteAllForUser = ()=>{
                    
                axios.delete('localhost:8081/api/users/1/questions')
                .then(function(reponse){
                    if(reponse === 200) FetchQuestions();
                })
                .catch(function(error){
                    console.log(error);
                    console.log('An error has been detected, please try again');
                })
    
        }

  useEffect(() => {
    FetchQuestions();
  }, []);



  const updateState = (index, val) => (e) => {
   
    const newArray = questions.map((item, i) => {
      if (index === i) {
        console.log("update " + item.id + " rating " + val);
        //return setQuestions(item.rating, { value: val })
        item.rating=val;
        return item;
        //return { ...item, [e.target.rating]: val };
      } else {
        return item;
      }
    });
    setQuestions(newArray);
    console.log(questions);
  };

  const handleChange = (date) =>{
    setStartDate(date);
    //console.log(date);
    //onsole.log(startDate);
    FetchQuestionsRatings(date);
    console.log("change"+isNew);
    //if(isNew){
    //   FetchQuestions();
    //}
  }

  const ClearData = () => {
    axios.delete('http://localhost:8081/api/users/1/questions')
          .then(function(reponse){
              if(reponse === 200) FetchQuestions();
          })
          .catch(function(error){
              console.log(error);
              console.log('An error has been detected, please try again');
          })
  }

  const dateFormat = (date)=>{
    var year = date.toLocaleString("default", { year: "numeric" });
    var month = date.toLocaleString("default", { month: "2-digit" });
    var day = date.toLocaleString("default", { day: "2-digit" });

    // Generate yyyy-mm-dd date string
    return year + "-" + month + "-" + day;
  }

    return (
        <>
<form>
        <h1>Select Date:</h1>
                    <DatePicker style="text-align:center;" name='dt' selected={startDate} value={startDate} dateFormat="yyyy-MM-dd" maxDate={new Date()} onChange={(date) => handleChange(date)} />
        
        <ul>
           
           {questions.map((question, index) => (
<li>

   {question.description}

 
   <input type="radio" id={question.id +"1"} name={question.id} value={question.rating} checked={question.rating === 1}  onChange={updateState(index, 1)}/><label for="1">1</label>
   <input type="radio" id={question.id +"2"} name={question.id} value={question.rating} checked={question.rating === 2}  onChange={updateState(index, 2)}/><label for="2">2</label>
   <input type="radio" id={question.id +"3"} name={question.id} value={question.rating} checked={question.rating === 3}  onChange={updateState(index, 3)}/><label for="3">3</label>
   <input type="radio" id={question.id +"4"} name={question.id} value={question.rating} checked={question.rating === 4}   onChange={updateState(index, 4)}/><label for="4">4</label>
   <input type="radio" id={question.id +"5"} name={question.id} value={question.rating} checked={question.rating === 5}  onChange={updateState(index, 5)}/><label for="5">5</label>

</li>
))}

</ul>
<button type='button' onClick={() => {addUserQuestionRating(questions)}}>Submit</button>
<button onClick={() => ClearData()}>Clear All</button>
            
        </form>

           
</>
    );
  }
  
  export default FormPage;