CREATE DATABASE gamehour;

-- ====================================================
-- 資料表：Member (會員)
-- ====================================================
CREATE TABLE MEMBER (
        MEMBER_ID SERIAL PRIMARY KEY,
        MEMBER_ACCOUNT VARCHAR(50),
        MEMBER_PASSWORD VARCHAR(20),
        MEMBER_GENDER CHAR(1),
        MEMBER_NAME VARCHAR(20),
        MEMBER_ONLINE_STATUS BOOLEAN,
        FAVORITE_GAME_TYPE VARCHAR(200) 
);
ALTER TABLE MEMBER ADD COLUMN MEMBER_CURRENT_ROOM VARCHAR(20);

-- ====================================================
-- 資料表：PLATFORM (遊戲平台)
-- ====================================================
CREATE TABLE PLATFORM (
        ID SERIAL PRIMARY KEY,
        NAME VARCHAR(50),
        LOGO VARCHAR(50),
        AVAILABILITY BOOLEAN
);

-- ====================================================
-- 資料表：GAME (遊戲)
-- ====================================================
CREATE TABLE GAME (
        ID SERIAL PRIMARY KEY,
        CHN_NAME VARCHAR(50),
        PLATFORM INT REFERENCES PLATFORM (ID),
        ENG_NAME VARCHAR(50),
        RELEASE_DATE DATE
);

-- ====================================================
-- 資料表：GAME_ROOM (遊戲房間)
-- ====================================================

CREATE TABLE GAME_ROOM (
        ID SERIAL PRIMARY KEY,
        ROOM_NAME VARCHAR(50),
        GAME_NAME INT REFERENCES GAME (ID),
        HOST CHAR(1),
        PLATFORM INT REFERENCES PLATFORM (ID),
        MEMBER_ONLINE_STATUS BOOLEAN,
        MEMBER_CURRENT_ROOM VARCHAR(20)
);

-- ====================================================
-- 資料表：RELATION (會員關係)
-- ====================================================

CREATE TABLE RELATION (
        MAIN_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATED_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATIONSHIP CHAR(1),
        CREATE_DATE DATE
);











