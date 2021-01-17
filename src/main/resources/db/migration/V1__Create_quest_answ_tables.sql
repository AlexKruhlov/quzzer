CREATE TABLE answer_options
(
    id uuid NOT NULL
        CONSTRAINT answer_options_pkey
            PRIMARY KEY ,
    answer_option_text VARCHAR(255)
);

ALTER TABLE answer_options OWNER TO quizzer;

CREATE TABLE questions
(
    id uuid NOT NULL
        CONSTRAINT questions_pkey
            PRIMARY KEY ,
    question_strategy VARCHAR(255),
    question_text VARCHAR(255)
);

ALTER TABLE questions OWNER TO quizzer;

CREATE TABLE questions_answer_options
(
    question_id uuid NOT NULL
        CONSTRAINT fko7los2sgwlsw6jsfhwpl7fjud
            REFERENCES questions,
    answer_option_id uuid NOT NULL
        CONSTRAINT qao_answer_option_id_ao
            REFERENCES answer_options
);

ALTER TABLE questions_answer_options OWNER TO quizzer;

CREATE TABLE answers
(
    id uuid NOT NULL
        CONSTRAINT answers_pkey
            PRIMARY KEY ,
    question_id uuid
        CONSTRAINT a_question_id_q
            REFERENCES questions
);

ALTER TABLE answers OWNER TO quizzer;

CREATE TABLE answers_answer_options
(
    answer_id uuid NOT NULL
        CONSTRAINT aao_answer_id_a
            REFERENCES answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT aao_answer_option_id_ao
            REFERENCES answer_options
);

ALTER TABLE answers_answer_options OWNER TO quizzer;

CREATE TABLE user_answers
(
    id uuid NOT NULL
        CONSTRAINT user_answers_pkey
            PRIMARY KEY ,
    submitting_time TIMESTAMP,
    question_id uuid
        CONSTRAINT ua_question_id_q
            REFERENCES questions
);

ALTER TABLE user_answers OWNER TO quizzer;

CREATE TABLE user_answers_answer_options
(
    user_answer_id uuid NOT NULL
        CONSTRAINT uaao_user_answer_id_ua
            REFERENCES user_answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT uaao_answer_option_id_ao
            REFERENCES answer_options
);

ALTER TABLE user_answers_answer_options OWNER TO quizzer;
