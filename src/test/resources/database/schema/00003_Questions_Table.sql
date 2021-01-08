CREATE TABLE quizzer.questions
(
    id uuid NOT NULL
        CONSTRAINT questions_pkey
            PRIMARY KEY ,
    question_strategy VARCHAR(255),
    question_text VARCHAR(255)
);
