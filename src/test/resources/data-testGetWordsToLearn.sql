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
VALUES (101, 'word1', 1005, ''),
       (102, 'word2', 1005, ''),
       (103, 'word3', 1005, ''),
       (104, 'word4', 1005, ''),
       (105, 'word5', 1005, ''),
       (106, 'word6', 1005, '');

INSERT INTO "study_rec"
VALUES (1, 101, 1, 3, 1, '2001-11-09 10:01:04', 1),
       (2, 102, 1, 3, 1, '2002-11-09 10:01:04', 1),
       (3, 103, 1, 3, 1, '2003-11-09 10:01:04', 1);

INSERT INTO "study_rec"
VALUES (6, 106, 1, 3, 1, '2023-11-09 10:01:04', 1);
//    (7, 107, 1, 3,1.1, '2023-10-21 10:01:04');
//   (8, 101, 1, 3,1.1, '2023-10-20 10:01:04'),data
//      (9, 102, 1, 3, 1.1,'2023-10-25 10:01:04');

//INSERT INTO "study_rec"
//VALUES (10, 102, 2, 3,1.1, '2023-10-26 01:02:03');
//     (11, 103, 3, 3, '2023-10-23 01:02:03'),
//    (12, 104, 3, 3, '2023-10-25 01:02:03');