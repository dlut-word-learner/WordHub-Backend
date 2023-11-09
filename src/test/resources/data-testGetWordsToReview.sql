SELECT word.word_id, word.word_name, COUNT(study_rec.study_rec_id) AS study_count
FROM study_rec
         JOIN word ON study_rec.word_id = word.word_id
WHERE study_rec.user_id = 1
  AND word.dict_id = 1001
GROUP BY word.word_id, word.word_name
ORDER BY MAX(study_rec.study_rec_date_time) ASC
