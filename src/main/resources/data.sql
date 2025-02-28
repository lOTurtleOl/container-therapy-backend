-- Insert users
INSERT INTO user (user_name, user_password, user_email, user_created_at) VALUES
('Alice', 'password123', 'alice@example.com', '2025-02-27'),
('Bob', 'securePass456', 'bob@example.com', '2025-02-27'),
('Charlie', 'charliePass789', 'charlie@example.com', '2025-02-27'),
('David', 'davidPass321', 'david@example.com', '2025-02-27'),
('Emma', 'emmaPass654', 'emma@example.com', '2025-02-27');

-- Insert containers (each assigned to a user)
INSERT INTO container (container_name, container_is_public, container_created_at, user_id) VALUES
('Alice Container', TRUE, '2025-02-27', 1),
('Bob Container', FALSE, '2025-02-27', 2),
('Charlie Container', TRUE, '2025-02-27', 3),
('David Container', FALSE, '2025-02-27', 4),
('Emma Container', TRUE, '2025-02-27', 5);

-- Insert topics (each assigned to a container)
INSERT INTO topic (topic_name, topic_date, topic_created_by, topic_created_at, container_id) VALUES
('Alice Topic', '2025-02-27', 'Alice', '2025-02-27', 1),
('Bob Topic', '2025-02-27', 'Bob', '2025-02-27', 2),
('Charlie Topic', '2025-02-27', 'Charlie', '2025-02-27', 3),
('David Topic', '2025-02-27', 'David', '2025-02-27', 4),
('Emma Topic', '2025-02-27', 'Emma', '2025-02-27', 5);
