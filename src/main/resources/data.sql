INSERT INTO users (name, email, pass, git_hub_user) VALUES
('Joao Carlos', 'joao@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'joaocarloslima'),
('Carla Lopes', 'carla@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'carla');

INSERT INTO tasks (title, description, point, status, user_id) VALUES
('Analise', 'analise completa do sistemas', 100, 90, 1),
('Protype', 'prototipacao das telas', 100, 70, null),
('Data base', 'criacao do banco de dados', 50, 10, null),
('Teste', 'teste de integração', 80, 20, 2);