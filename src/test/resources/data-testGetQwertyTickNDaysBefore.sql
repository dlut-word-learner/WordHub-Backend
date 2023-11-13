INSERT INTO "dict"
values (1005, 'Test', 'testDict');

INSERT INTO "user"
VALUES ( 1, 'user1', '123456', '1@abc.cn'
       , 0, 0),
       ( 2, 'user2', '123456', '2@abc.cn'
       , 0, 0),
       ( 3, 'user3', '123456', '3@abc.cn'
       , 0, 0);

INSERT INTO "word"
VALUES (101, 'word1', 1005, '{}'),
       (102, 'word2', 1005, '{}'),
       (103, 'word3', 1005, '{}'),
       (104, 'word4', 1005, '{}'),
       (105, 'word5', 1005, '{}'),
       (106, 'word6', 1005, '{}');

INSERT INTO "qwerty_rec"
(qwerty_rec_id,user_id,dict_id,qwerty_num,qwerty_rec_time)
VALUES
    (1,1, 1005, 5,  dateadd(DAY, 0, CURRENT_DATE)),
    (2,1, 1005, 5,  dateadd(DAY, -1, CURRENT_DATE)),
    (3,1, 1005, 5,  dateadd(DAY, -1, CURRENT_DATE)),
    (4,1, 1005, 5,  dateadd(DAY, -3, CURRENT_DATE)),
    (5,1, 1005, 5,  dateadd(DAY, -3, CURRENT_DATE)),
    (6,1, 1005, 5,  dateadd(DAY, -4, CURRENT_DATE))
;