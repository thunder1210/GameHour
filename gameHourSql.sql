CREATE DATABASE gamehour;

-- ====================================================
-- 資料表：Member (會員)
-- ====================================================
DROP TABLE MEMBER;
CREATE TABLE MEMBER (
        MEMBER_ID SERIAL PRIMARY KEY,
        MEMBER_ACCOUNT VARCHAR(50),
        MEMBER_PASSWORD VARCHAR(20),
        MEMBER_GENDER CHAR(1),
        MEMBER_NAME VARCHAR(20),
        MEMBER_ONLINE_STATUS BOOLEAN,
        MEMBER_CURRENT_ROOM VARCHAR(20),
        FAVORITE_GAME_TYPE VARCHAR(200)
)

INSERT INTO MEMBER (MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_GENDER, MEMBER_NAME, MEMBER_ONLINE_STATUS, FAVORITE_GAME_TYPE, MEMBER_CURRENT_ROOM)
VALUES ('thunder1210', '123456', 'M', 'thunder', true, '1, 2, 3, 5', null),
('chuck9845', 'c65055', 'M', 'chuck', true, '1', null);
-- ====================================================
-- 資料表：PLATFORM (遊戲平台)
-- ====================================================
DROP TABLE PLATFORM;
CREATE TABLE PLATFORM (
        ID SERIAL PRIMARY KEY,
        NAME VARCHAR(50),
        LOGO VARCHAR(50),
        AVAILABILITY BOOLEAN
);
INSERT INTO PLATFORM (NAME, LOGO, AVAILABILITY) 
VALUES('Steam', 'LOGO', true), ('PlayStation 4', 'LOGO', true), ('Nintendo Switch', 'LOGO', true), ('PlayStation 5', 'LOGO', true);

-- ====================================================
-- 資料表：GAME (遊戲)
-- ====================================================
DROP TABLE GAME;
CREATE TABLE GAME (
        ID SERIAL PRIMARY KEY,
        CHN_NAME VARCHAR(50),
        PLATFORM INT REFERENCES PLATFORM (ID),
        ENG_NAME VARCHAR(50),
        RELEASE_DATE DATE,
        GAME_TYPE INT REFERENCES GAME_TYPE (ID)
);
INSERT INTO GAME (chn_name, platform, eng_name, release_date, game_type) 
VALUES('惡靈古堡：啟示2', 3, 'Resident Evil : Relevation 2', '2015-07-13', 11), 
('紙板馬力歐', 3, 'Paper Mario!', '2024-05-25', 1);

-- ====================================================
-- 資料表：GAME_ROOM (遊戲房間)
-- ====================================================
DROP TABLE GAME_ROOM;
CREATE TABLE GAME_ROOM (
        ID SERIAL PRIMARY KEY,
        ROOM_NAME VARCHAR(50),
        GAME_NAME INT REFERENCES GAME (ID),
        PLATFORM INT REFERENCES PLATFORM (ID),
        HOST INT REFERENCES MEMBER (MEMBER_ID),
        IS_TIME_LIMITED BOOLEAN
);

-- ====================================================
-- 資料表：RELATION (會員關係)
-- ====================================================
DROP TABLE RELATION;
CREATE TABLE RELATION (
        MAIN_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATED_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATIONSHIP CHAR(1),
        CREATE_DATE DATE
);

-- ====================================================
-- 資料表：GAME_TPYE (遊戲類型)
-- ====================================================
DROP TABLE GAME_TYPE;
CREATE TABLE GAME_TYPE (
        ID SERIAL PRIMARY KEY,
        TYPE_NAME_CHN VARCHAR(20),
        TYPE_NAME_ENG VARCHAR(20)
);

INSERT INTO GAME_TYPE(TYPE_NAME_CHN, TYPE_NAME_ENG) 
VALUES('動作遊戲', 'Action'), ('射擊遊戲', 'Shooter'), ('冒險遊戲', 'Adventure'), ('角色扮演遊戲', 'Role-playing'),
('戰略遊戲', 'Strategy'), ('模擬遊戲', 'Simulation'), ('橫向卷軸遊戲', 'Side-scrolling'), ('豎向卷軸遊戲', 'Vertical-scrolling'),
('沙盒遊戲', 'Sandbox'), ('戰爭遊戲', 'War'), ('恐怖遊戲', 'Horror'), ('解謎遊戲', 'Puzzle'), ('運動遊戲', 'Sports'),
('競速遊戲', 'Racing'), ('音樂遊戲', 'Music'), ('卡牌遊戲', 'Card'), ('益智遊戲', 'Casual'), ('即時戰略遊戲', 'Real-time Strategy'),
('戰術遊戲', 'Tactical'), ('潛行遊戲', 'Stealth');
