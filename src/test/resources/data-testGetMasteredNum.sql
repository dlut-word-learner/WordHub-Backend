-- SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
--
-- SPDX-License-Identifier: AGPL-3.0-or-later

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
(study_rec_id ,word_id,user_id,study_rec_gap,study_rec_ease,study_rec_due_time,study_rec_tick)
VALUES (1, 101, 1, 1, 1, dateadd(month , -1, CURRENT_DATE), 1),
       (2, 101, 1, 1, 1, dateadd(month , 2, CURRENT_DATE), 2),
       (3, 102, 1, 1, 1, dateadd(month, -1, CURRENT_DATE), 1),
       (4, 102, 1, 1, 1, CURRENT_TIMESTAMP, 2),
       (5, 102, 1, 1, 1, dateadd(day, 20, CURRENT_DATE), 3),
       (6, 103, 1, 3, 1, dateadd(month,2,CURRENT_DATE), 1)

;

