CREATE TABLE quizzer.answer_options
(
    id uuid NOT NULL
        CONSTRAINT answer_options_pkey
            PRIMARY KEY ,
    answer_option_text VARCHAR(255)
);
