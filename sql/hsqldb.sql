CREATE TABLE book (
   id bigint not null,
   name varchar(100),
   PRIMARY KEY (id)
 );


INSERT INTO book (id,name) VALUES(1,'OpenYu');

SELECT id,name FROM book where id=1;


CREATE TABLE magazine (
   id bigint not null,
   name varchar(100),
   price int,
   PRIMARY KEY (id)
 );

    --author_id bigint,

ALTER TABLE magazine ADD COLUMN buff varchar(100);

ALTER TABLE magazine DROP COLUMN buff;