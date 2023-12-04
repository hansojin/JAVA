CREATE TABLE bankbook(
	name varchar(50),
	balance int
);

INSERT INTO bankbook values('starTraveller', 10000);

CREATE TABLE pointbook(
	name varchar(50),
	point int
);

INSERT INTO pointbook values('starTraveller', 1000);

SELECT * FROM bankbook;
SELECT * FROM pointbook;

DROP TABLE bankbook, pointbook;