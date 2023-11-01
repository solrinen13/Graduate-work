# Graduation project
## Group diploma work.

The task of the team Unassembled was to write the backend part of the site in Java for the finished frontend part and implement the following functionality:

- Authorization and authentication of users.
- Distribution of roles between users: user and administrator*.
- CRUD for ads on the site: the administrator can delete or edit all ads, and users — only their own.
- Under each ad, users can leave reviews.
- In the site header, you can search for ads by name.
- Show and save images of ads.

## Technical specification of the project:
- [Technical task](https://skyengpublic.notion.site/64113e0a2641475c9ad9bea93144afff)

## The development team "Unassembled":

- Савелий Каныгин
- Надежда Дроголова
- Сергей Турабов
- Ирина Борисова
 
## Technology stack:
**The project uses**:
 
* Backend:
    - Java 11
    - Maven
    - Spring Boot
    - Spring Web
    - Spring Data
    - Spring JPA
    - Spring Security
    - GIT
    - REST
    - Swagger
    - Lombok
    - Stream API
* SQL:
    - PostgreSQL
    - Liquibase
* Frontend:
    - Docker image

## Launch:
**To start, you need:**
- Clone a project into a development environment
- Register properties in the file **[application.properties](src/main/resources/application.properties)**
- To run **[Docker](https://www.docker.com)**
- To run **[Docker image](https://drive.google.com/file/d/1UZTpeTAQpC4ANkHEFAGK2yjTFzZhXLPz/view)**
- To run method **main** in the file **[HomeworkApplication.java](src/main/java/ru/skypro/homework/HomeworkApplication.java)**

After completing all the actions, the site will be accessible by following the link http://localhost:3000 and Swagger by [link](https://editor.swagger.io/).
