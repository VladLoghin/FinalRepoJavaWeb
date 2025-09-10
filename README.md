# FinalRepoJavaWeb
finalProjectRepo


NOTE "I did not manage to make the data.sql file work so you have to use the proper sql commands to your h2-console"

Project link: https://github.com/VladLoghin/FinalRepoJavaWeb

Description:

My application is made to have data inserted based on what the user has selected on a rating from 1 to 5 of questions.

ex: Question: How were you feeling today
    User: Selects 5
    

The application stores the data inputed by the user by date and the user can select a particular date in which they can see how they did on the particular day.

The user can also change the values that they have previously entered and insert more data into the application

The user can also choose to change the input that they have previously inserted into their application

The user can also choose to play around with a little heart switch implemented and when it is switched on, the little ball changes color

The project requires you run this line of sql code:
INSERT INTO User_Application (username) VALUES ('Vlad');
INSERT INTO User_Application (username) VALUES ('Dan');

INSERT INTO Questions (Description, Active) VALUES ('How much did you exercise today?', 1);
INSERT INTO Questions (Description, Active) VALUES ('Did you feel productive today?', 1);
INSERT INTO Questions (Description, Active) VALUES ('How well did you eat today?', 1);
INSERT INTO Questions (Description, Active) VALUES ('How motivated were you today?', 1);
INSERT INTO Questions (Description, Active) VALUES ('How well do you feel your day went today?', 1);

This will make it so the questions and users are added to the db 

During this project I have faced many challenges:

the main one being that I originally wanted to put a chart, but I could not do that since I ran into many problems trying to insert the api requests into the project. 

A second problem I have encountered is the fact that I had to use dates for my data. From this project, I have learned that dates are a very hard variable to manipulate and should be used to a minimum when doing reactjs projects. For this reason, this app was not able to be completed in the way I had first envisionned it to be finished. 

Design:

This project has many ways that you can manipulate data, the first one being get user, which simply gets the user of the application by username and id.

The second one is Get Questions, which gets the id, description being what the question is, active saying wheather the question is active or not, meaning it checks if the question can be used or not but it is not implemented and rating which has the score bound to the question.

The third one is Get UserQuestionRatings, this endpoint gets the question ratings by id of the user.

The fourth one is Get UserQuestionRatingsTotal, this one was supposed to be used for the chartjs, but is no longer being used in the project, but it basically all the ratings entered by the user and compiles them into one with a loop that adds them all up together.

The fifth one is Add UserQuestionRatings, which allows the user to set the values of his ratings.

The sixth one is Update UserQuestionRatings, which allows the user to change his ratings.

And the last one is Delete UserQuestionRatings, which deletes all of the ratings by the user id, meaning that it deletes all of the ratings.

Entity-Relationship Diagram:



End-points:

localhost:8081/api/users/{id}

localhost:8081/api/questions

localhost:8081/api/users/{id}/questions?{date}

localhost:8081/api/users/{id}/questionsRatingTotal

localhost:8081/api/users/{id}/questions?{date}

localhost:8081/api/users/{id}/questions

![Alt text] (https://imgur.com/a/lXEU2BK) "final Project screenshot"

the datepicker allows the user to pick the date they want to insert data into after compleating the form and hitting the submit button, the user can also modify said data later on after selecting the date previously selected and then pushing the submit button in the app and delete all the data with the clear button.

The heart button is there for the user to click and it changes the color of it
