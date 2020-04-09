insert into user(user_id, password) values ('hamill', '1234');

insert into column(name, user, user_key) values ('해야할일', 1, 0);
insert into column(name, user, user_key) values ('하는중', 1, 1);
insert into column(name, user, user_key) values ('다했어', 1, 2);

insert into card(note, column, column_key, user, user_key) values ('맛있는 김치볶음밥', 3, 0, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('재밌는 코드스쿼드',3, 1, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('투두앱만들기~',3, 2, 1, 0);

insert into card(note, column, column_key, user, user_key) values ('맛없어', 2, 0, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('슬기로운 깜빵생활',2, 1, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('히히헤헤',2, 2, 1, 0);

insert into card(note, column, column_key, user, user_key) values ('떡순이', 1, 0, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('떡돌이',1, 1, 1, 0);
insert into card(note, column, column_key, user, user_key) values ('떡튀순',1, 2, 1, 0);
