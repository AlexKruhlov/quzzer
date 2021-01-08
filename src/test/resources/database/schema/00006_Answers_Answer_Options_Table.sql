CREATE TABLE quizzer.answers_answer_options
(
    answer_id uuid NOT NULL
        CONSTRAINT aao_answer_id_a
            REFERENCES quizzer.answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT aao_answer_option_id_ao
            REFERENCES quizzer.answer_options
);
