CREATE TABLE quizzer.answers
(
    id uuid NOT NULL
        CONSTRAINT answers_pkey
            PRIMARY KEY ,
    question_id uuid
        CONSTRAINT a_question_id_q
            REFERENCES quizzer.questions
);
