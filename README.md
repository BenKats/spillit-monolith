# Fullstack



Fullstack is a fullstack application with a RESTful application connected to a front end all built from scratch.

## Collaborators

* [Ramel Haines]
* [Benjamin Kats]


### Technologies Used

* [Spring] - Used for creating our backend API
* PostgreSQ - Used for storing and retrieving data from our relational database
* HTML/CSS/Javascript - Used to build the front-end of our application

[Ramel Haines]: https://github.com/EngineerMel
[Benjamin Kats]: https://github.com/BenKats
[Spring]: https://spring.io

## General Approach 

We first reviewed the technical requirements, necessary deliverables and sketched a wireframe to achieve our project tasks. We reached a consensus that it was important to continousluy clarify our project goals throughout the week to ensure that our project work remained aligned with the initial premise. On Day 1, we listed the model we would need, their end points, and the relationship the tables would have to each other. We created a task list on Trello to visualize what we needed to do at stage of the process. Using the task list, we estimated the time it would take to acccomplish each task to prepare for unforeseen problems in our creative process. Below is a timeline of how we planned our project.


| Day         | 1       | 2       | 3       | 4       | 5       | 6       | 7     |
|------------ |-------- |-------- |-------- |-------- |---------|---------|-------|
|Morning Task |Separated workout flow by working on separate branches to avoid merge conflicts |Added necessary fields to the User, UserProfile, Post, and Comment models |Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day|Organize tasks to complete for the day and reviewed the code from the previous day |
|Afternoon Task |Sketched out the tables, relational mapping, endpoints, and ERD diagram |Created User, Comment, and Post tables. Added hiberate dialect in pom.xml|set security to give all users the role USER, created and logged in a user and returned a token |Added endpoints to Post and Comment controllers |Completed unit tests using mocks and stubs/Handled exceptions |Refactored all the domains on the front-end and reach full functionality of the website |
|Evening Task |Launched Spring and created packages for models, repositories, and services. Also, added dependencies to our database |Added Repository interfaces, Controller classes, and jwt token security config |Tested and Refactored endpoints for Users(Signup, Login, List All Users) |Refactored code and tested endpoints |Refactored code and tested endpoints/Began to update routes to connect to our front-end | Update ReadMe(Major Hurdles, User Storie) and begin to redesign front-end |


## Major Hurdles
** Cross-origin resource sharing(CORS)
** Testing UserService login functionality


## Installation Instructions

## User Stories
** As a news reporter, I want to make an account to deliver news updates to the online community.
** As a user interface designer, I want to see white boarding sessions from other designers to improve my skills.
** As a user, I want to edit my contact details so I can keep up to date.
** As a Business user, I can post information about my products so that potential customers can learn about my business. 
