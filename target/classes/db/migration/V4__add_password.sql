
ALTER TABLE users
ADD password VARCHAR(32) NOT NULL DEFAULT 'NOT_EXISTS';

UPDATE users
SET password = MD5(RANDOM()::text)
WHERE password = 'NOT_EXISTS';
