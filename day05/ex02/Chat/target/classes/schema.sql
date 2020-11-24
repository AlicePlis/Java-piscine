CREATE TABLE users (
	id BIGSERIAL PRIMARY KEY,
	login text UNIQUE NOT NULL,
	password text,
	createdRooms bigint[],
	rooms bigint[]
);

CREATE TABLE rooms (
	id BIGSERIAL PRIMARY KEY,
	name text NOT NULL,
	creator bigint REFERENCES users(id),
	messages bigint[]
);

CREATE TABLE messages (
	id BIGSERIAL PRIMARY KEY,
	author bigint REFERENCES users(id),
	room bigint REFERENCES rooms(id),
	text text,
	date timestamp
);

CREATE USER postgres WITH LOGIN PASSWORD '1234';