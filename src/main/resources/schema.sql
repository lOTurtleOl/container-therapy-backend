DROP TABLE IF EXISTS topic_subtopic;
DROP TABLE IF EXISTS subtopic;
DROP TABLE IF EXISTS topic;
DROP TABLE IF EXISTS container;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
	user_id int NOT NULL AUTO_INCREMENT,
	user_name varchar(128) NOT NULL,
	user_password varchar(128) NOT NULL,
	user_email varchar(128) NOT NULL,
	user_created_at varchar(60)
	PRIMARY KEY (user_id)	
);

CREATE TABLE container (
	container_id int NOT NULL AUTO_INCREMENT,
	container_name varchar(128) NOT NULL,
	container_is_public boolean NOT NULL,
	container_created_at varchar(128),
	PRIMARY KEY (container_id)
	FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE
);


CREATE TABLE topic (
	topic_id int NOT NULL AUTO_INCREMENT,
	topic_value varchar(128) NOT NULL,
	topic_date varchar(60) NOT NULL,
	topic_created_by varchar(60) NOT NULL,
	topic_created_at varchar(60)
	PRIMARY KEY (topic_id)
	FOREIGN KEY (container_id) REFERENCES container (container_id) ON CASCADE DELETE
);

CREATE TABLE subtopic (
	subtopic_id int NOT NULL AUTO_INCREMENT,
	subtopic_value varchar(128) NOT NULL,
	subtopic_date varchar(60) NOT NULL,
	subtopic_created_by varchar(60) NOT NULL,
	subtopic_created_at varchar(60)
	PRIMARY KEY (subtopic_id)
);

CREATE TABLE topic_subtopic (
	topic_id int NOT NULL,
	subtopic_id int NOT NULL,
	FOREIGN KEY (topic_id) REFERENCES topic (topic_id) ON DELETE CASCADE,
	FOREIGN KEY (subtopic_id) REFERENCES subtopic (subtopic_id) ON DELETE CASCADE
);