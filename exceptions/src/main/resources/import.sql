INSERT INTO author(code, name) VALUES('COD1','Oracle')
INSERT INTO author(code, name) VALUES('COD2','IBM')

INSERT INTO book(code, name) VALUES('COD1', 'Java SE')
INSERT INTO book(code, name) VALUES('COD2', 'Oracle DB')
INSERT INTO book(code, name) VALUES('COD3', 'Cibersecurity')

INSERT INTO book_author(author_id, book_id) VALUES(1,1)
INSERT INTO book_author(author_id, book_id) VALUES(1,2)
INSERT INTO book_author(author_id, book_id) VALUES(1,3)
INSERT INTO book_author(author_id, book_id) VALUES(2,3)

INSERT INTO user(code, name) VALUES('COD1', 'HENRY' );
INSERT INTO user(code, name) VALUES('COD2', 'ANDRES' );
INSERT INTO user(code, name) VALUES('COD3', 'MOSQUERA' );
INSERT INTO user(code, name) VALUES('COD4', 'PEREZ' );

INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Java SE', 1, 1)
INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Oracle DB', 2, 1)
INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Cibersecurity', 3, 1)
INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Java SE', 1, 2)
INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Oracle DB', 2, 3)
INSERT INTO review(commentary, book_id, user_id) VALUES('Nice book Cibersecurity', 3, 4)


