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
    title varchar(64),
    user int references user(id),
    user_key int,
    previous_id bigint
);

CREATE TABLE card (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    note varchar(500),
    column int references column(id),
    column_key int,
    user int references user(id),
    previous_id bigint
);
