CREATE TABLE quizzer.user_answers
(
    id uuid NOT NULL
        CONSTRAINT user_answers_pkey
            PRIMARY KEY ,
    submitting_time TIMESTAMP,
    question_id uuid
        CONSTRAINT u_a_question_id_q
            REFERENCES quizzer.questions
);
