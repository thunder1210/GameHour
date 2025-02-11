# Side Project - *GameHour*

## GameHour是什麼? 
忙碌的社會，分秒必爭的現代  
GameHour旨在打造讓所有玩家可以『快速、便利』匹配連線遊戲房，  
並找到志同道合好友的全新網站。

## 資料庫
PostgreSQL, Redis
## 使用技術
SpringBoot (3.3.0) 框架開發、RabbitMQ、MyBatis Plus、Docker、WebSocket
## TECHNIQUE USEMENT
***RabbitMQ應用場景：***  
Websocket消息存儲轉發/分流處理

    [Github] Related file path:  
    /src/main/resources/templates/index.html  
    /src/main/java/com/thunder/gamehour/comsumer/WebSocketComsumer.java

所有會員可透過前端大廳聊天窗口發出訊息，在WebSocket的Server端接收後，把json格式的Message送到RabbitMQ的Queue當中，
並透過多個Consumer輪流處理，來分散同一時間收到大量訊息的處理  

![Websocket message processed by RabbitMQ](https://github.com/thunder1210/GameHour/blob/master/material/RabbitMQ_Flow.png)


***

***Redis & Cache應用場景：***  
對於並非高度要求精準性的資料，則使用Redis緩存資料，並額外添增Refresh按鈕，讓有需求的會員也能即時更新數據  
故將GameHour主頁的線上會員清單暫存處理，同時也加快訪問頁面的資料存取速度

    [Github] Related file path:    
    /src/main/java/com/thunder/gamehour/config/RedisCacheConfig.java  
    /src/main/java/com/thunder/gamehour/service/MembershipService.java  
    /src/main/java/com/thunder/gamehour/controller/MemberController.java  

![Websocket message processed by RabbitMQ](https://github.com/thunder1210/GameHour/blob/master/material/GameHourMainPage.png)

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
  
## Swagger UI 

![Websocket message processed by RabbitMQ](https://github.com/thunder1210/GameHour/blob/master/material/SwaggerUI.png)

| EntryPoint | URL |
|--|--|
| Swagger | localhost:8080/swagger-ui/index.html |

You may use swagger from this project to test and ask for response. 
