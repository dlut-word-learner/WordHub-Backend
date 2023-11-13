INSERT INTO "language"
VALUES ('English'),
       ('Japanese'),
       ('Test');

INSERT INTO "dict"
VALUES (0, 'Test', 'Test'),
       (2, 'English', 'CET-4'),
       (3, 'English', 'CET-6'),
       (4, 'English', 'GaoKao-3500'),
       (5, 'English', 'IELTS_disorder'),
       (6, 'English', 'TOEFL'),
       (7, 'English', 'TOEIC');

INSERT INTO `user`
VALUES ( 1000001, 'test_1', '123456', '123@abc.cn', 0, 0);

INSERT INTO "word"
VALUES (1000001, 'sing', 0, '{
  "name": "sing",
  "usphone": "sɪŋ",
  "ukphone": "sɪŋ",
  "trans": [
    "唱歌"
  ]
}'),
       (1000002, 'check', 0, '{
         "name": "check",
         "usphone": "tʃek",
         "ukphone": "tʃek",
         "trans": [
           "检查，核对"
         ]
       }'),
       (1000003, 'evening', 0, '{
         "name": "evening",
         "usphone": "ˈiːvnɪŋ",
         "ukphone": "ˈiːvnɪŋ",
         "trans": [
           "晚上"
         ]
       }');