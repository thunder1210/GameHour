CREATE OR REPLACE FUNCTION create_database_if_not_exists()
RETURNS VOID AS $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_catalog.pg_database WHERE datname = 'gamehour') THEN
        CREATE DATABASE gamehour;
    END IF;
END;
$$ LANGUAGE plpgsql;

SELECT create_database_if_not_exists();
-- ====================================================
-- 資料表：Member (會員)
-- ====================================================
CREATE TABLE IF NOT EXISTS MEMBER (
        MEMBER_ID SERIAL PRIMARY KEY,
        MEMBER_ACCOUNT VARCHAR(50),
        MEMBER_PASSWORD VARCHAR(20),
        MEMBER_GENDER CHAR(1),
        MEMBER_NAME VARCHAR(20),
        MEMBER_ONLINE_STATUS BOOLEAN,
        MEMBER_CURRENT_ROOM VARCHAR(20),
        FAVORITE_GAME_TYPE VARCHAR(200)
);

INSERT INTO MEMBER (MEMBER_ACCOUNT, MEMBER_PASSWORD, MEMBER_GENDER, MEMBER_NAME, MEMBER_ONLINE_STATUS, FAVORITE_GAME_TYPE, MEMBER_CURRENT_ROOM)
VALUES ('thunder1210', '123456', 'M', 'thunder', true, '1, 2, 3, 5', null),
('chuck9845', 'c65055', 'M', 'chuck', true, '1', null),
('bart4452s', 'a5s96aa', 'M', 'bart', true, '5', null),
('barry_ew32', 'd9f9ds', 'F', 'barry', true, '1, 5, 9', null);
-- ====================================================
-- 資料表：RELATION (會員關係)
-- ====================================================
CREATE TABLE IF NOT EXISTS RELATION (
        MAIN_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATED_MEMBER INT REFERENCES MEMBER (MEMBER_ID),
        RELATIONSHIP CHAR(1),
        CREATE_DATE DATE
);

-- ====================================================
-- 資料表：PLATFORM (遊戲平台)
-- ====================================================
CREATE TABLE IF NOT EXISTS PLATFORM (
        ID SERIAL PRIMARY KEY,
        NAME VARCHAR(50),
        LOGO VARCHAR(50),
        AVAILABILITY BOOLEAN
);


INSERT INTO PLATFORM (NAME, LOGO, AVAILABILITY) 
VALUES('Steam', 'LOGO', true), ('PlayStation 4', 'LOGO', true), ('Nintendo Switch', 'LOGO', true), ('PlayStation 5', 'LOGO', true);

-- ====================================================
-- 資料表：GAME_TPYE (遊戲類型)
-- ====================================================
CREATE TABLE IF NOT EXISTS GAME_TYPE (
        ID SERIAL PRIMARY KEY,
        TYPE_NAME_CHN VARCHAR(20),
        TYPE_NAME_ENG VARCHAR(20)
);

-- ====================================================
-- 資料表：GAME (遊戲)
-- ====================================================
CREATE TABLE IF NOT EXISTS GAME (
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
CREATE TABLE IF NOT EXISTS GAME_ROOM (
        ID SERIAL PRIMARY KEY,
        ROOM_NAME VARCHAR(50),
        GAME_NAME INT REFERENCES GAME (ID),
        PLATFORM INT REFERENCES PLATFORM (ID),
        HOST INT REFERENCES MEMBER (MEMBER_ID),
        IS_TIME_LIMITED BOOLEAN
);

INSERT INTO GAME_TYPE(TYPE_NAME_CHN, TYPE_NAME_ENG) 
VALUES('動作遊戲', 'Action'), ('射擊遊戲', 'Shooter'), ('冒險遊戲', 'Adventure'), ('角色扮演遊戲', 'Role-playing'),
('戰略遊戲', 'Strategy'), ('模擬遊戲', 'Simulation'), ('橫向卷軸遊戲', 'Side-scrolling'), ('豎向卷軸遊戲', 'Vertical-scrolling'),
('沙盒遊戲', 'Sandbox'), ('戰爭遊戲', 'War'), ('恐怖遊戲', 'Horror'), ('解謎遊戲', 'Puzzle'), ('運動遊戲', 'Sports'),
('競速遊戲', 'Racing'), ('音樂遊戲', 'Music'), ('卡牌遊戲', 'Card'), ('益智遊戲', 'Casual'), ('即時戰略遊戲', 'Real-time Strategy'),
('戰術遊戲', 'Tactical'), ('潛行遊戲', 'Stealth');
