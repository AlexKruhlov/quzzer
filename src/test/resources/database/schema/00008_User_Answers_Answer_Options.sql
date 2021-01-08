CREATE TABLE quizzer.user_answers_answer_options
(
    user_answer_id uuid NOT NULL
        CONSTRAINT uaao_user_answer_id_ua
            REFERENCES quizzer.user_answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT uaao_answer_option_id_ao
            REFERENCES quizzer.answer_options
);
