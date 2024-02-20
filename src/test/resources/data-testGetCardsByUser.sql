-- SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
--
-- SPDX-License-Identifier: AGPL-3.0-or-later

INSERT INTO "user"
VALUES (1003, 'testCard', '123456', '234@abc.cn', 0, 0);

INSERT INTO "user"
VALUES (1004, 'testCard2', '123456', '456@abc.cn', 0, 0);

INSERT INTO "dict"
values (1022, 'Test', 'test1');

INSERT INTO "word"
VALUES (101, 'word1', 1022, '{
  "ukphone": "uk",
  "usphone": "us"
}'),
       (102, 'word2', 1022, '');

INSERT INTO "card"
VALUES (1002, 101, 'this is testCard', 0, 1003),
       (1003, 102, 'this is testCard', 0, 1003),
       (1004, 102, 'this is testCard', 0, 1004);