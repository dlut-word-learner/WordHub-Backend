INSERT INTO `language`
VALUES ('English'),
       ('Japanese');

INSERT INTO `dict`
VALUES (1, 'English', 'CET6'),
       (2, 'Japanese', 'JLPT_N3');

INSERT INTO `user`
VALUES (1,'Dami', 123456, '123@456.com',0,0);

INSERT INTO `study_rec`
(word_id,user_id,study_rec_gap,study_rec_ease,study_rec_due_time,study_rec_tick)
VALUES (1,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
   (1,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
   (1,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
   (1,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
   (1,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

   (2,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
   (2,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
   (2,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
   (2,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
   (2,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

(3,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(3,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
(3,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
(3,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
(3,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

(4,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(4,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
(4,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
(4,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
(4,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

(5,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(5,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
(5,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
(5,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
(5,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

(6,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(6,1,3,2.15,date_add(CURRENT_DATE, interval -50 DAY),2),
(6,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),
(6,1,7,1.70,date_add(CURRENT_DATE, interval -25 DAY),4),
(6,1,9,2.0,date_add(CURRENT_DATE, interval -5 DAY),5),

-- part2
(7,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(7,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(7,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(7,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(7,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(8,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(8,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(8,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(8,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(8,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(9,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(9,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(9,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(9,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(9,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(10,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(10,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(10,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(10,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(10,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(11,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(11,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(11,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(11,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(11,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(12,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(12,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(12,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(12,1,7,1.70,date_add(CURRENT_DATE, interval -24 DAY),4),
(12,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

-- part3
(13,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(13,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(13,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(13,1,7,1.70,date_add(CURRENT_DATE, interval -26 DAY),4),
(13,1,9,2.0,date_add(CURRENT_DATE, interval -3 DAY),5),

(14,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(14,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(14,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(14,1,7,1.70,date_add(CURRENT_DATE, interval -26 DAY),4),
(14,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(15,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(15,1,3,2.15,date_add(CURRENT_DATE, interval -49 DAY),2),
(15,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(15,1,7,1.70,date_add(CURRENT_DATE, interval -26 DAY),4),
(15,1,9,2.0,date_add(CURRENT_DATE, interval -3 DAY),5),

-- part4
(16,1,3,2.15,date_add(CURRENT_DATE, interval -45 DAY),1),
(16,1,5,1.85,date_add(CURRENT_DATE, interval -30 DAY),2),
(16,1,10,2,date_add(CURRENT_DATE, interval -10 DAY),3),

(17,1,3,2.15,date_add(CURRENT_DATE, interval -45 DAY),1),
(17,1,5,1.85,date_add(CURRENT_DATE, interval -30 DAY),2),
(17,1,10,2,date_add(CURRENT_DATE, interval -10 DAY),3),

(18,1,3,2.15,date_add(CURRENT_DATE, interval -42 DAY),1),
(18,1,5,1.85,date_add(CURRENT_DATE, interval -22 DAY),2),
(18,1,7,2,date_add(CURRENT_DATE, interval -13 DAY),3),

(19,1,3,2.15,date_add(CURRENT_DATE, interval -41 DAY),1),
(19,1,5,1.85,date_add(CURRENT_DATE, interval -21 DAY),2),
(19,1,7,2,date_add(CURRENT_DATE, interval -12 DAY),3),

(20,1,3,2.15,date_add(CURRENT_DATE, interval -41 DAY),1),
(20,1,5,1.85,date_add(CURRENT_DATE, interval -21 DAY),2),
(20,1,7,2,date_add(CURRENT_DATE, interval -12 DAY),3),


(21,1,3,2.15,date_add(CURRENT_DATE, interval -22 DAY),1),
(21,1,5,1.85,date_add(CURRENT_DATE, interval -12 DAY),2),
(21,1,7,2,date_add(CURRENT_DATE, interval -3 DAY),3),

(22,1,3,2.15,date_add(CURRENT_DATE, interval -21 DAY),1),
(22,1,5,1.85,date_add(CURRENT_DATE, interval -11 DAY),2),
(22,1,7,2,date_add(CURRENT_DATE, interval -3 DAY),3),

(23,1,3,2.15,date_add(CURRENT_DATE, interval -20 DAY),1),
(23,1,5,1.85,date_add(CURRENT_DATE, interval -10 DAY),2),


(24,1,3,2.15,date_add(CURRENT_DATE, interval -33 DAY),1),
(24,1,5,1.85,date_add(CURRENT_DATE, interval -22 DAY),2),
(24,1,10,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(25,1,3,2.15,date_add(CURRENT_DATE, interval -33 DAY),1),
(25,1,5,1.85,date_add(CURRENT_DATE, interval -22 DAY),2),
(25,1,10,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(26,1,3,2.15,date_add(CURRENT_DATE, interval -43 DAY),1),
(26,1,5,1.85,date_add(CURRENT_DATE, interval -21 DAY),2),
(26,1,7,2,date_add(CURRENT_DATE, interval -6 DAY),3),

(27,1,3,2.15,date_add(CURRENT_DATE, interval -43 DAY),1),
(27,1,5,1.85,date_add(CURRENT_DATE, interval -21 DAY),2),
(27,1,7,2,date_add(CURRENT_DATE, interval -6 DAY),3),

(28,1,3,2.15,date_add(CURRENT_DATE, interval -41 DAY),1),
(28,1,5,1.85,date_add(CURRENT_DATE, interval -11 DAY),2),
(28,1,7,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(29,1,3,2.15,date_add(CURRENT_DATE, interval -36 DAY),1),
(29,1,5,1.85,date_add(CURRENT_DATE, interval -16 DAY),2),
(29,1,7,2,date_add(CURRENT_DATE, interval -8 DAY),3),

(30,1,3,2.15,date_add(CURRENT_DATE, interval -34 DAY),1),
(30,1,5,1.85,date_add(CURRENT_DATE, interval -12 DAY),2),
(30,1,7,2,date_add(CURRENT_DATE, interval -7 DAY),3),

(31,1,3,2.15,date_add(CURRENT_DATE, interval -39 DAY),1),
(31,1,5,1.85,date_add(CURRENT_DATE, interval -16 DAY),2),
(31,1,7,2,date_add(CURRENT_DATE, interval -5 DAY),3),

(32,1,3,2.15,date_add(CURRENT_DATE, interval -37 DAY),1),
(32,1,5,1.85,date_add(CURRENT_DATE, interval -15 DAY),2),
(32,1,7,2,date_add(CURRENT_DATE, interval -4 DAY),3),

(33,1,3,2.15,date_add(CURRENT_DATE, interval -37 DAY),1),
(33,1,5,1.85,date_add(CURRENT_DATE, interval -10 DAY),2),
(33,1,7,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(34,1,3,2.15,date_add(CURRENT_DATE, interval -33 DAY),1),
(34,1,5,1.85,date_add(CURRENT_DATE, interval -13 DAY),2),
(34,1,7,2,date_add(CURRENT_DATE, interval 0 DAY),3),

(35,1,3,2.15,date_add(CURRENT_DATE, interval -55 DAY),1),
(35,1,5,1.85,date_add(CURRENT_DATE, interval -44 DAY),2),
(35,1,7,2,date_add(CURRENT_DATE, interval -11 DAY),3),

(36,1,2,2.15,date_add(CURRENT_DATE, interval -50 DAY),1),
(36,1,4,1.85,date_add(CURRENT_DATE, interval -19 DAY),2),
(36,1,6,2,date_add(CURRENT_DATE, interval -11 DAY),3),

(38,1,2,2.15,date_add(CURRENT_DATE, interval -44 DAY),1),
(38,1,4,1.85,date_add(CURRENT_DATE, interval -19 DAY),2),
(38,1,6,2,date_add(CURRENT_DATE, interval -11 DAY),3),

(39,1,2,2.15,date_add(CURRENT_DATE, interval -22 DAY),1),
(39,1,4,1.85,date_add(CURRENT_DATE, interval -10 DAY),2),
(39,1,6,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(40,1,2,2.15,date_add(CURRENT_DATE, interval -27 DAY),1),
(40,1,4,1.85,date_add(CURRENT_DATE, interval -16 DAY),2),
(40,1,6,2,date_add(CURRENT_DATE, interval -8 DAY),3),

(41,1,2,2.15,date_add(CURRENT_DATE, interval -29 DAY),1),
(41,1,4,1.85,date_add(CURRENT_DATE, interval -14 DAY),2),
(41,1,6,2,date_add(CURRENT_DATE, interval -8 DAY),3),

(42,1,2,2.15,date_add(CURRENT_DATE, interval -30 DAY),1),
(42,1,4,1.85,date_add(CURRENT_DATE, interval -17 DAY),2),
(42,1,6,2,date_add(CURRENT_DATE, interval -7 DAY),3),

(43,1,2,2.15,date_add(CURRENT_DATE, interval -27 DAY),1),
(43,1,4,1.85,date_add(CURRENT_DATE, interval -16 DAY),2),
(43,1,6,2,date_add(CURRENT_DATE, interval -8 DAY),3),

(44,1,3,2.15,date_add(CURRENT_DATE, interval -37 DAY),1),
(44,1,5,1.85,date_add(CURRENT_DATE, interval -15 DAY),2),
(44,1,7,2,date_add(CURRENT_DATE, interval -4 DAY),3),

(45,1,3,2.15,date_add(CURRENT_DATE, interval -34 DAY),1),
(45,1,5,1.85,date_add(CURRENT_DATE, interval -12 DAY),2),
(45,1,7,2,date_add(CURRENT_DATE, interval -7 DAY),3),

(46,1,3,2.15,date_add(CURRENT_DATE, interval -41 DAY),1),
(46,1,5,1.85,date_add(CURRENT_DATE, interval -21 DAY),2),
(46,1,7,2,date_add(CURRENT_DATE, interval -12 DAY),3),

(47,1,2,2.15,date_add(CURRENT_DATE, interval -29 DAY),1),
(47,1,4,1.85,date_add(CURRENT_DATE, interval -14 DAY),2),
(47,1,6,2,date_add(CURRENT_DATE, interval -8 DAY),3),

(48,1,2,2.15,date_add(CURRENT_DATE, interval -45 DAY),1),
(48,1,4,1.85,date_add(CURRENT_DATE, interval -18 DAY),2),
(48,1,6,2,date_add(CURRENT_DATE, interval -2 DAY),3),

(49,1,2,2.15,date_add(CURRENT_DATE, interval -45 DAY),1),
(49,1,4,1.85,date_add(CURRENT_DATE, interval -18 DAY),2),
(49,1,6,2,date_add(CURRENT_DATE, interval -2 DAY),3),

(50,1,2,2.15,date_add(CURRENT_DATE, interval -34 DAY),1),
(50,1,4,1.85,date_add(CURRENT_DATE, interval -16 DAY),2),
(50,1,6,2,date_add(CURRENT_DATE, interval -1 DAY),3),

(51,1,2,2.15,date_add(CURRENT_DATE, interval -45 DAY),1),
(51,1,4,1.85,date_add(CURRENT_DATE, interval -18 DAY),2),
(51,1,6,2,date_add(CURRENT_DATE, interval -2 DAY),3),

(52,1,2,2.0,date_add(CURRENT_DATE, interval -47 DAY),1),
(52,1,3,2.15,date_add(CURRENT_DATE, interval -44 DAY),2),
(52,1,5,1.85,date_add(CURRENT_DATE, interval -33 DAY),3),
(52,1,7,1.70,date_add(CURRENT_DATE, interval -22 DAY),4),
(52,1,9,2.0,date_add(CURRENT_DATE, interval -9 DAY),5),

(53,1,2,2.0,date_add(CURRENT_DATE, interval -59 DAY),1),
(53,1,3,2.15,date_add(CURRENT_DATE, interval -55 DAY),2),
(53,1,5,1.85,date_add(CURRENT_DATE, interval -49 DAY),3),

(54,1,2,2.0,date_add(CURRENT_DATE, interval -58 DAY),1),
(54,1,3,2.15,date_add(CURRENT_DATE, interval -56 DAY),2),
(54,1,5,1.85,date_add(CURRENT_DATE, interval -49 DAY),3),

(55,1,2,2.0,date_add(CURRENT_DATE, interval -59 DAY),1),
(55,1,3,2.15,date_add(CURRENT_DATE, interval -55 DAY),2),
(55,1,5,1.85,date_add(CURRENT_DATE, interval -48 DAY),3),

(56,1,2,2.0,date_add(CURRENT_DATE, interval -59 DAY),1),
(56,1,3,2.15,date_add(CURRENT_DATE, interval -55 DAY),2),
(56,1,5,1.85,date_add(CURRENT_DATE, interval -42 DAY),3),


(57,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(57,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(57,1,5,1.85,date_add(CURRENT_DATE, interval -42 DAY),3),

(58,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(58,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(58,1,5,1.85,date_add(CURRENT_DATE, interval -45 DAY),3),

(59,1,2,2.0,date_add(CURRENT_DATE, interval -57 DAY),1),
(59,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(59,1,5,1.85,date_add(CURRENT_DATE, interval -41 DAY),3),

(60,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(60,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(60,1,5,1.85,date_add(CURRENT_DATE, interval -47 DAY),3),

(61,1,2,2.0,date_add(CURRENT_DATE, interval -52 DAY),1),
(61,1,3,2.15,date_add(CURRENT_DATE, interval -45 DAY),2),
(61,1,5,1.85,date_add(CURRENT_DATE, interval -38 DAY),3),

(62,1,2,2.0,date_add(CURRENT_DATE, interval -59 DAY),1),
(62,1,3,2.15,date_add(CURRENT_DATE, interval -43 DAY),2),
(62,1,5,1.85,date_add(CURRENT_DATE, interval -33 DAY),3),

(63,1,2,2.0,date_add(CURRENT_DATE, interval -54 DAY),1),
(63,1,3,2.15,date_add(CURRENT_DATE, interval -43 DAY),2),
(63,1,5,1.85,date_add(CURRENT_DATE, interval -31 DAY),3),

(64,1,2,2.0,date_add(CURRENT_DATE, interval -52 DAY),1),
(64,1,3,2.15,date_add(CURRENT_DATE, interval -44 DAY),2),
(64,1,5,1.85,date_add(CURRENT_DATE, interval -36 DAY),3),

(65,1,2,2.0,date_add(CURRENT_DATE, interval -51 DAY),1),
(65,1,3,2.15,date_add(CURRENT_DATE, interval -47 DAY),2),
(65,1,5,1.85,date_add(CURRENT_DATE, interval -40 DAY),3),

(66,1,2,2.0,date_add(CURRENT_DATE, interval -57 DAY),1),
(66,1,3,2.15,date_add(CURRENT_DATE, interval -52 DAY),2),
(66,1,5,1.85,date_add(CURRENT_DATE, interval -31 DAY),3),
(66,1,7,1.70,date_add(CURRENT_DATE, interval -21 DAY),4),
(66,1,9,2.0,date_add(CURRENT_DATE, interval -4 DAY),5),

(67,1,2,2.0,date_add(CURRENT_DATE, interval -55 DAY),1),
(67,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(67,1,5,1.85,date_add(CURRENT_DATE, interval -33 DAY),3),
(67,1,7,1.70,date_add(CURRENT_DATE, interval -17 DAY),4),
(67,1,9,2.0,date_add(CURRENT_DATE, interval -3 DAY),5),

(68,1,2,2.0,date_add(CURRENT_DATE, interval -56 DAY),1),
(68,1,3,2.15,date_add(CURRENT_DATE, interval -51 DAY),2),
(68,1,5,1.85,date_add(CURRENT_DATE, interval -33 DAY),3),
(68,1,7,1.70,date_add(CURRENT_DATE, interval -19 DAY),4),
(68,1,9,2.0,date_add(CURRENT_DATE, interval -7 DAY),5),

(69,1,2,2.0,date_add(CURRENT_DATE, interval -49 DAY),1),
(69,1,3,2.15,date_add(CURRENT_DATE, interval -44 DAY),2),
(69,1,5,1.85,date_add(CURRENT_DATE, interval -39 DAY),3),
(69,1,7,1.70,date_add(CURRENT_DATE, interval -30 DAY),4),
(69,1,9,2.0,date_add(CURRENT_DATE, interval -20 DAY),5),

(70,1,2,2.0,date_add(CURRENT_DATE, interval -48 DAY),1),
(70,1,3,2.15,date_add(CURRENT_DATE, interval -42 DAY),2),
(70,1,5,1.85,date_add(CURRENT_DATE, interval -35 DAY),3),
(70,1,7,1.70,date_add(CURRENT_DATE, interval -28 DAY),4),
(70,1,9,2.0,date_add(CURRENT_DATE, interval -18 DAY),5);



