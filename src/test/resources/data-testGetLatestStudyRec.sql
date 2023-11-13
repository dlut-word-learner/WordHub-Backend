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

INSERT INTO "study_rec"
(study_rec_id ,word_id,user_id, study_rec_gap,study_rec_ease,study_rec_due_time,study_rec_tick)
VALUES (1, 101, 1, 1, 2, '2023-11-09 10:01:04', 1),
       (2, 101, 1, 1, 1, '2022-11-09 10:01:04', 2);
 //      (3, 102, 1, 2, 1, dateadd(DAY, 1, CURRENT_DATE), 2),
   //    (4, 103, 1, 3, 1, dateadd(DAY ,-1,CURRENT_DATE), 2),
    //   (5, 104, 1, 4, 1, CURRENT_TIMESTAMP, 3)


