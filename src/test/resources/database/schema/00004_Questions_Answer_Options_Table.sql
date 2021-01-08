CREATE TABLE quizzer.questions_answer_options
(
    question_id uuid NOT NULL
        CONSTRAINT qao_question_id_q
            REFERENCES quizzer.questions,
    answer_option_id uuid NOT NULL
        CONSTRAINT qao_answer_option_id_ao
            REFERENCES quizzer.answer_options
);
