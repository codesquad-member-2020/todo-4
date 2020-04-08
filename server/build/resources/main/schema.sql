-- DROP TABLE IF EXITS card;
-- DROP TABLE IF EXITS column;
-- DROP TABLE IF EXITS user;

CREATE TABLE user (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    user_id varchar(64),
    password varchar(64)
);

CREATE TABLE column (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    name varchar(64),
    user int references user(id),
    user_key int
);
