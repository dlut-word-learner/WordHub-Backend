-- SPDX-FileCopyrightText: 2024 WordHub <integral@member.fsf.org>
--
-- SPDX-License-Identifier: AGPL-3.0-or-later

INSERT INTO "dict"
VALUES (1002, 'Test', 'Test');

INSERT INTO "word"
VALUES (101, 'word1', 1002, '{
  "ukphone": "uk",
  "usphone": "us"
}');