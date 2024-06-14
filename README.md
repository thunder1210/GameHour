# GameHour 
## About
*'GameHour' is an ideal Website based on gamer-online-battle and Joyful moments.* 
the project was developed by own myself. 
## Build Steps - How to get started?
- Clone this project into your local workspace.
- Open Windows cmd/Linux terminal, switch to the root  under GameHour project.
- Use docker command to build image and run.
> **cmd1:** docker build -t gamehour:latest . (include the dot)

> **cmd2:** docker run -d -p 8080:8080 --name gamehour_container gamehour:lastest
- User docker-compose to build required containers
> **cmd:** docker-compose up -d . (include the dot)
- Run each SQL command in **/src/main/resources/gameHour.sql** to create a sample enviroment.
- Don't forget to edit the **application.yml** file, set the database url as your local IP address
- 
## Technologies Used
Springboot, RabbitMQ, MyBatis Plus, Docker, WebSocket

## DataBase
PostgreSQL,  Redis

## Project API
| EntryPoint | URL |
|--|--|
| Swagger | localhost:8080/swagger-ui/index.html |

You may use swagger from this project to test and ask for response. 
## FrontPage
## GameRoom Lobby
## The 'Explore' page


produced by Nathaniel.Zhao
