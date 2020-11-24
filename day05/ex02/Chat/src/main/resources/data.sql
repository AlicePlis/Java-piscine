
INSERT INTO users (login, password, rooms, createdRooms) VALUES ('Alice', '000000', '{1}', '{1}');
INSERT INTO users (login, password, rooms, createdRooms) VALUES ('Nick', '111111', '{2}', '{2}');
INSERT INTO users (login, password, rooms, createdRooms) VALUES ('Marie', '222222', '{3}', '{3}');
INSERT INTO users (login, password, rooms, createdRooms) VALUES ('George', '333333', '{4}', '{4}');
INSERT INTO users (login, password, rooms, createdRooms) VALUES ('Lucy', '444444', '{5}', '{5}');

INSERT INTO rooms (name, creator, messages) VALUES ('1', 1, '{1}');
INSERT INTO rooms (name, creator, messages) VALUES ('2', 2, '{2}');
INSERT INTO rooms (name, creator, messages) VALUES ('3', 3, '{3}');
INSERT INTO rooms (name, creator, messages) VALUES ('4', 4, '{4}');
INSERT INTO rooms (name, creator, messages) VALUES ('5', 5, '{5}');

INSERT INTO messages (id, room, author, text, date) VALUES (1, 1, 1, 'kek', '1970-01-01 00:00:01');
INSERT INTO messages (id, room, author, text, date) VALUES (2, 2, 2, 'lol', '1970-01-01 00:00:02');
INSERT INTO messages (id, room, author, text, date) VALUES (3, 3, 3, 'cry', '1970-01-01 00:00:03');
INSERT INTO messages (id, room, author, text, date) VALUES (4, 4, 4, 'pip', '1970-01-01 00:00:04');
INSERT INTO messages (id, room, author, text, date) VALUES (5, 5, 5, 'pupip', '1970-01-01 00:00:05');


