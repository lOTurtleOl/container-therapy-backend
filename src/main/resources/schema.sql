DROP TABLE IF EXISTS topic_subtopic;
DROP TABLE IF EXISTS topic;
DROP TABLE IF EXISTS subtopic;
DROP TABLE IF EXISTS container;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
	user_id BIGINT NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(128) NOT NULL,
	user_password VARCHAR(128) NOT NULL,
	user_email VARCHAR(128) NOT NULL,
	user_created_at VARCHAR(60),
	PRIMARY KEY (user_id)	
);

CREATE TABLE container (
	container_id BIGINT NOT NULL AUTO_INCREMENT,
	container_name VARCHAR(128) NOT NULL,
	container_is_public boolean NOT NULL,
	container_created_at VARCHAR(128),
	user_id BIGINT,
	PRIMARY KEY (container_id),
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
);


CREATE TABLE topic (
	topic_id BIGINT NOT NULL AUTO_INCREMENT,
	topic_name VARCHAR(128) NOT NULL,
	topic_date VARCHAR(60) NOT NULL,
	topic_created_by VARCHAR(60) NOT NULL,
	topic_created_at VARCHAR(60),
	container_id BIGINT,
	PRIMARY KEY (topic_id),
	FOREIGN KEY (container_id) REFERENCES container (container_id) ON DELETE CASCADE
);

CREATE TABLE subtopic (
	subtopic_id BIGINT NOT NULL AUTO_INCREMENT,
	subtopic_name VARCHAR(128) NOT NULL,
	subtopic_date VARCHAR(60) NOT NULL,
	subtopic_created_by VARCHAR(60) NOT NULL,
	subtopic_created_at VARCHAR(60),
	PRIMARY KEY (subtopic_id)
);

CREATE TABLE topic_subtopic (
	topic_id BIGINT NOT NULL,
	subtopic_id BIGINT NOT NULL,
	FOREIGN KEY (topic_id) REFERENCES topic (topic_id) ON DELETE CASCADE,
	FOREIGN KEY (subtopic_id) REFERENCES subtopic (subtopic_id) ON DELETE CASCADE
);