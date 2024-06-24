# Side Project - *GameHour*

## GameHour是什麼? 
忙碌的社會，分秒必爭的現代，
GameHour旨在打造讓所有玩家可以『快速、便利』匹配連線遊戲房，
並找到志同道合好友的全新網站。

## 資料庫
PostgreSQL, Redis
## 使用技術
SpringBoot (3.3.0) 框架開發、RabbitMQ、MyBatis Plus、Docker、WebSocket
## Project API
![https://ibb.co/2n3DvQC](https://ibb.co/2n3DvQC)

<details>
<summary>Build Steps -How to get Started?</summary>

## Commands
- Clone this project into your local workspace.
- Open Windows cmd/Linux terminal, switch to the root  under GameHour project.
- Use docker command to build image and run.
> **cmd1:** docker build -t gamehour:latest . (include the dot)

> **cmd2:** docker run -d -p 8080:8080 --name gamehour_container gamehour:lastest
- User docker-compose to build required containers
> **cmd:** docker-compose up -d . (include the dot)
- Run each SQL command in **/src/main/resources/gameHour.sql** to create a sample enviroment.
- Don't forget to edit the **application.yml** file, set the database url as your local IP address
</details>

<details>
<summary>Project API</summary>
  
## Swagger
| EntryPoint | URL |
|--|--|
| Swagger | localhost:8080/swagger-ui/index.html |

You may use swagger from this project to test and ask for response. 

</details>
