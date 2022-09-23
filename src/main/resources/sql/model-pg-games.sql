
DROP INDEX IF EXISTS games_name_index;

DROP TABLE IF EXISTS games CASCADE;

DROP SEQUENCE IF EXISTS games_id_seq;

CREATE SEQUENCE games_id_seq INCREMENT BY 1 START WITH 1;

CREATE TABLE games
  (
    id INTEGER PRIMARY KEY DEFAULT nextval('games_id_seq'),
    name TEXT
  );

CREATE UNIQUE INDEX games_name_index ON games (lower(name));

INSERT INTO GAMES (name) VALUES ('cyberpunk');
