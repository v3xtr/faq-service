CREATE TABLE questions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- Добавили дефолт для UUID
    question TEXT NOT NULL
);

CREATE TABLE answers (
     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
     text TEXT NOT NULL,
     question_id UUID,
     CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES questions (id) ON DELETE CASCADE
);

CREATE INDEX idx_questions_fts ON questions USING gin(to_tsvector('russian', question));

CREATE INDEX idx_answers_question_id ON answers(question_id);