CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    image VARCHAR(500) NOT NULL
);

CREATE TABLE units (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    points DOUBLE NOT NULL,
    `index` INT NOT NULL,
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
        REFERENCES courses (id)
        ON DELETE CASCADE
);

CREATE TABLE lessons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    unit_id BIGINT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    points DOUBLE NOT NULL,
    `index` INT NOT NULL,
    CONSTRAINT fk_unit
        FOREIGN KEY (unit_id)
        REFERENCES units (id)
        ON DELETE CASCADE
);

CREATE TABLE questions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lesson_id BIGINT,
    description TEXT NOT NULL,
    `index` INT NOT NULL,
    CONSTRAINT fk_lesson
        FOREIGN KEY (lesson_id)
        REFERENCES lessons (id)
        ON DELETE CASCADE
);
