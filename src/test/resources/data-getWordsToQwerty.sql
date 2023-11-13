INSERT INTO "dict"
values (1001, 'Test', 'test1');

INSERT INTO "word"
VALUES (101, 'word1', 1001, '{}'),
       (102, 'word2', 1001, '{"ukphone": "uk", "usphone": "us", "trans": ["trans1", "trans2"]}'),
       (103, 'word3', 1001, '{}'),
       (104, 'word4', 1001, '{}');