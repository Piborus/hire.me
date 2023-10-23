CREATE TABLE shortUrl (
    id BIGSERIAL PRIMARY KEY,
    shortUrl VARCHAR(255),
    longUrl VARCHAR(255)
);