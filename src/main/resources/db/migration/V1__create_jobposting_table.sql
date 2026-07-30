CREATE TABLE jobposts (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    company_id BIGINT NOT NULL,
    title varchar(150) NOT NULL,
    description varchar(500) NOT NULL,
    local varchar(500) NOT NULL,
    create_at DATE DEFAULT CURRENT_DATE
);