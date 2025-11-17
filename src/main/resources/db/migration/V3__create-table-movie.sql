CREATE TABLE movie (

    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    img_url TEXT NOT NULL,
    release_date DATE NOT NULL,
    rating NUMERIC,
    created_at TIMESTAMP,
    updated_at TIMESTAMP

);