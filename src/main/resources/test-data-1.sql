INSERT INTO "language"
VALUES ('English'),
       ('Japanese');

INSERT INTO "dict"
VALUES (1, 'English', 'CET6'),
       (2, 'Japanese', 'JLPT_N3');

INSERT INTO `user`
VALUES (1,Dami, 123456,);

INSERT INTO "study_rec"
(word_id,user_id,study_rec_gap,study_rec_ease,study_rec_due_time,study_rec_tick)
VALUES
-- (1,"word_id",1,gap_1.5,2.XX,"study_rec_due_time",TICK)
   (1,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
   (1,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
   (1,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
   (1,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
   (1,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

   (2,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
   (2,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
   (2,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
   (2,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
   (2,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

(3,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
(3,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
(3,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
(3,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
(3,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

(4,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
(4,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
(4,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
(4,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
(4,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

(5,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
(5,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
(5,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
(5,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
(5,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

(6,1,2,2.0,dateadd(DAY, -55, CURRENT_DATE),1),
(6,1,3,2.15,dateadd(DAY, -50, CURRENT_DATE),2),
(6,1,5,1.85,dateadd(DAY, -40, CURRENT_DATE),3),
(6,1,7,1.70,dateadd(DAY, -25, CURRENT_DATE),4),
(6,1,9,2.0,dateadd(DAY, -5, CURRENT_DATE),5),

--part2
(7,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(7,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(7,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(7,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(7,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(8,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(8,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(8,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(8,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(8,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(9,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(9,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(9,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(9,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(9,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(10,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(10,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(10,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(10,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(10,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(11,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(11,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(11,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(11,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(11,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(12,1,2,2.0,dateadd(DAY, -54, CURRENT_DATE),1),
(12,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(12,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(12,1,7,1.70,dateadd(DAY, -24, CURRENT_DATE),4),
(12,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

--part3
(13,1,2,2.0,dateadd(DAY, -56, CURRENT_DATE),1),
(13,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(13,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(13,1,7,1.70,dateadd(DAY, -26, CURRENT_DATE),4),
(13,1,9,2.0,dateadd(DAY, -3, CURRENT_DATE),5),

(14,1,2,2.0,dateadd(DAY, -56, CURRENT_DATE),1),
(14,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(14,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(14,1,7,1.70,dateadd(DAY, -26, CURRENT_DATE),4),
(14,1,9,2.0,dateadd(DAY, -4, CURRENT_DATE),5),

(15,1,2,2.0,dateadd(DAY, -56, CURRENT_DATE),1),
(15,1,3,2.15,dateadd(DAY, -49, CURRENT_DATE),2),
(15,1,5,1.85,dateadd(DAY, -39, CURRENT_DATE),3),
(15,1,7,1.70,dateadd(DAY, -26, CURRENT_DATE),4),
(15,1,9,2.0,dateadd(DAY, -3, CURRENT_DATE),5),

--part4
(16,1,3,2.15,dateadd(DAY, -45, CURRENT_DATE),1),
(16,1,5,1.85,dateadd(DAY, -30, CURRENT_DATE),2),
(16,1,10,2,dateadd(DAY, -10, CURRENT_DATE),3),

(17,1,3,2.15,dateadd(DAY, -45, CURRENT_DATE),1),
(17,1,5,1.85,dateadd(DAY, -30, CURRENT_DATE),2),
(17,1,10,2,dateadd(DAY, -10, CURRENT_DATE),3),

(18,1,3,2.15,dateadd(DAY, -42, CURRENT_DATE),1),
(18,1,5,1.85,dateadd(DAY, -22, CURRENT_DATE),2),
(18,1,7,2,dateadd(DAY, -13, CURRENT_DATE),3),

(19,1,3,2.15,dateadd(DAY, -41, CURRENT_DATE),1),
(19,1,5,1.85,dateadd(DAY, -21, CURRENT_DATE),2),
(19,1,7,2,dateadd(DAY, -12, CURRENT_DATE),3),

(20,1,3,2.15,dateadd(DAY, -41, CURRENT_DATE),1),
(20,1,5,1.85,dateadd(DAY, -21, CURRENT_DATE),2),
(20,1,7,2,dateadd(DAY, -12, CURRENT_DATE),3),


(21,1,3,2.15,dateadd(DAY, -22, CURRENT_DATE),1),
(21,1,5,1.85,dateadd(DAY, -12, CURRENT_DATE),2),
(21,1,7,2,dateadd(DAY, -3, CURRENT_DATE),3),

(22,1,3,2.15,dateadd(DAY, -21, CURRENT_DATE),1),
(22,1,5,1.85,dateadd(DAY, -11, CURRENT_DATE),2),
(22,1,7,2,dateadd(DAY, -3, CURRENT_DATE),3),

(23,1,3,2.15,dateadd(DAY, -20, CURRENT_DATE),1),
(23,1,5,1.85,dateadd(DAY, -10, CURRENT_DATE),2),


(24,1,3,2.15,dateadd(DAY, -33, CURRENT_DATE),1),
(24,1,5,1.85,dateadd(DAY, -22, CURRENT_DATE),2),
(24,1,10,2,dateadd(DAY, -1, CURRENT_DATE),3),

(25,1,3,2.15,dateadd(DAY, -33, CURRENT_DATE),1),
(25,1,5,1.85,dateadd(DAY, -22, CURRENT_DATE),2),
(25,1,10,2,dateadd(DAY, -1, CURRENT_DATE),3),

(26,1,3,2.15,dateadd(DAY, -43, CURRENT_DATE),1),
(26,1,5,1.85,dateadd(DAY, -21, CURRENT_DATE),2),
(26,1,7,2,dateadd(DAY, -6, CURRENT_DATE),3),

(27,1,3,2.15,dateadd(DAY, -43, CURRENT_DATE),1),
(27,1,5,1.85,dateadd(DAY, -21, CURRENT_DATE),2),
(27,1,7,2,dateadd(DAY, -6, CURRENT_DATE),3),

(28,1,3,2.15,dateadd(DAY, -41, CURRENT_DATE),1),
(28,1,5,1.85,dateadd(DAY, -11, CURRENT_DATE),2),
(28,1,7,2,dateadd(DAY, -1, CURRENT_DATE),3),

(29,1,3,2.15,dateadd(DAY, -36, CURRENT_DATE),1),
(29,1,5,1.85,dateadd(DAY, -16, CURRENT_DATE),2),
(29,1,7,2,dateadd(DAY, -8, CURRENT_DATE),3),

(30,1,3,2.15,dateadd(DAY, -34, CURRENT_DATE),1),
(30,1,5,1.85,dateadd(DAY, -12, CURRENT_DATE),2),
(30,1,7,2,dateadd(DAY, -7, CURRENT_DATE),3),

(31,1,3,2.15,dateadd(DAY, -39, CURRENT_DATE),1),
(31,1,5,1.85,dateadd(DAY, -16, CURRENT_DATE),2),
(31,1,7,2,dateadd(DAY, -5, CURRENT_DATE),3),

(32,1,3,2.15,dateadd(DAY, -37, CURRENT_DATE),1),
(32,1,5,1.85,dateadd(DAY, -15, CURRENT_DATE),2),
(32,1,7,2,dateadd(DAY, -4, CURRENT_DATE),3),

(33,1,3,2.15,dateadd(DAY, -37, CURRENT_DATE),1),
(33,1,5,1.85,dateadd(DAY, -10, CURRENT_DATE),2),
(33,1,7,2,dateadd(DAY, -1, CURRENT_DATE),3),

(34,1,3,2.15,dateadd(DAY, -33, CURRENT_DATE),1),
(34,1,5,1.85,dateadd(DAY, -13, CURRENT_DATE),2),
(34,1,7,2,dateadd(DAY, 0, CURRENT_DATE),3),

(35,1,3,2.15,dateadd(DAY, -55, CURRENT_DATE),1),
(35,1,5,1.85,dateadd(DAY, -44, CURRENT_DATE),2),
(35,1,7,2,dateadd(DAY, -11, CURRENT_DATE),3),

(35,1,3,2.15,dateadd(DAY, -25, CURRENT_DATE),1),
(35,1,5,1.85,dateadd(DAY, -15, CURRENT_DATE),2),
(35,1,7,2,dateadd(DAY, -7, CURRENT_DATE),3),

(36,1,2,2.15,dateadd(DAY, -50, CURRENT_DATE),1),
(36,1,4,1.85,dateadd(DAY, -19, CURRENT_DATE),2),
(36,1,6,2,dateadd(DAY, -11, CURRENT_DATE),3),

(38,1,2,2.15,dateadd(DAY, -44, CURRENT_DATE),1),
(38,1,4,1.85,dateadd(DAY, -19, CURRENT_DATE),2),
(38,1,6,2,dateadd(DAY, -11, CURRENT_DATE),3),

(39,1,2,2.15,dateadd(DAY, -22, CURRENT_DATE),1),
(39,1,4,1.85,dateadd(DAY, -10, CURRENT_DATE),2),
(39,1,6,2,dateadd(DAY, -1, CURRENT_DATE),3),

(40,1,2,2.15,dateadd(DAY, -27, CURRENT_DATE),1),
(40,1,4,1.85,dateadd(DAY, -16, CURRENT_DATE),2),
(40,1,6,2,dateadd(DAY, -8, CURRENT_DATE),3),

(41,1,2,2.15,dateadd(DAY, -29, CURRENT_DATE),1),
(41,1,4,1.85,dateadd(DAY, -14, CURRENT_DATE),2),
(41,1,6,2,dateadd(DAY, -8, CURRENT_DATE),3),

(41,1,2,2.15,dateadd(DAY, -30, CURRENT_DATE),1),
(41,1,4,1.85,dateadd(DAY, -17, CURRENT_DATE),2),
(41,1,6,2,dateadd(DAY, -7, CURRENT_DATE),3),

(42,1,2,2.15,dateadd(DAY, -30, CURRENT_DATE),1),
(42,1,4,1.85,dateadd(DAY, -17, CURRENT_DATE),2),
(42,1,6,2,dateadd(DAY, -7, CURRENT_DATE),3),

(43,1,2,2.15,dateadd(DAY, -27, CURRENT_DATE),1),
(43,1,4,1.85,dateadd(DAY, -16, CURRENT_DATE),2),
(43,1,6,2,dateadd(DAY, -8, CURRENT_DATE),3),

(44,1,3,2.15,dateadd(DAY, -37, CURRENT_DATE),1),
(44,1,5,1.85,dateadd(DAY, -15, CURRENT_DATE),2),
(44,1,7,2,dateadd(DAY, -4, CURRENT_DATE),3),

(45,1,3,2.15,dateadd(DAY, -34, CURRENT_DATE),1),
(45,1,5,1.85,dateadd(DAY, -12, CURRENT_DATE),2),
(45,1,7,2,dateadd(DAY, -7, CURRENT_DATE),3),

(46,1,3,2.15,dateadd(DAY, -41, CURRENT_DATE),1),
(46,1,5,1.85,dateadd(DAY, -21, CURRENT_DATE),2),
(46,1,7,2,dateadd(DAY, -12, CURRENT_DATE),3),

(47,1,2,2.15,dateadd(DAY, -29, CURRENT_DATE),1),
(47,1,4,1.85,dateadd(DAY, -14, CURRENT_DATE),2),
(47,1,6,2,dateadd(DAY, -8, CURRENT_DATE),3),

(48,1,2,2.15,dateadd(DAY, -45, CURRENT_DATE),1),
(48,1,4,1.85,dateadd(DAY, -18, CURRENT_DATE),2),
(48,1,6,2,dateadd(DAY, -2, CURRENT_DATE),3),

(49,1,2,2.15,dateadd(DAY, -45, CURRENT_DATE),1),
(49,1,4,1.85,dateadd(DAY, -18, CURRENT_DATE),2),
(49,1,6,2,dateadd(DAY, -2, CURRENT_DATE),3),

(50,1,2,2.15,dateadd(DAY, -34, CURRENT_DATE),1),
(50,1,4,1.85,dateadd(DAY, -16, CURRENT_DATE),2),
(50,1,6,2,dateadd(DAY, -1, CURRENT_DATE),3);