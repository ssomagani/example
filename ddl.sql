DROP PROCEDURE SayHello IF EXISTS;
DROP TABLE hello IF EXISTS;

file -inlinebatch TABLES

CREATE TABLE hello (
	language VARCHAR(24) not null,
	text VARCHAR(32)	
);
PARTITION TABLE hello ON COLUMN language;

TABLES

load classes target/example-0.0.1-SNAPSHOT-jar-with-dependencies.jar;

file -inlinebatch PROCS

CREATE PROCEDURE PARTITION ON TABLE hello COLUMN language FROM CLASS com.voltdb.example.SayHello;

PROCS

INSERT INTO hello VALUES ('english', 'hello');
INSERT INTO hello VALUES ('hindi', 'namasthe');
