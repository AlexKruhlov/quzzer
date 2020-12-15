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
        CONSTRAINT fk6ei0cg1u52nxk31dlfb5fci0p
            REFERENCES answer_options
);

ALTER TABLE questions_answer_options OWNER TO quizzer;

CREATE TABLE answers
(
    id uuid NOT NULL
        CONSTRAINT answers_pkey
            PRIMARY KEY ,
    question_id uuid
        CONSTRAINT fk3erw1a3t0r78st8ty27x6v3g1
            REFERENCES questions
);

ALTER TABLE answers OWNER TO quizzer;

CREATE TABLE answers_answer_options
(
    answer_id uuid NOT NULL
        CONSTRAINT fkit2jx3ksh4wp5vvdvtl4o4lhw
            REFERENCES answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT fkip6qjmr0tno5gykjf9qgxv7mb
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
        CONSTRAINT fk6b46l4bb7a6wfxvmn6l7ig8vo
            REFERENCES questions
);

ALTER TABLE user_answers OWNER TO quizzer;

CREATE TABLE user_answers_answer_options
(
    user_answer_id uuid NOT NULL
        CONSTRAINT fk6ry0ehxshu7o7afehx2rj2kmu
            REFERENCES user_answers,
    answer_option_id uuid NOT NULL
        CONSTRAINT fk20v3e174uflc84f1lg505mgeq
            REFERENCES answer_options
);

ALTER TABLE user_answers_answer_options OWNER TO quizzer;
