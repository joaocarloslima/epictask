INSERT INTO users (name, email, pass, git_hub_user, point) VALUES
('Joao Carlos', 'joao@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'joaocarloslima', 0),
('Carla Lopes', 'carla@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'carla', 0);

INSERT INTO ROLE (name) values ('ROLE_ADMIN'), ('ROLE_USER'); 

INSERT INTO USERS_ROLES (USERS_ID, ROLES_ID) values 
(1,1), 
(2,2); 


INSERT INTO tasks (title, description, point, status, user_id) VALUES
('Analise', 'analise completa do sistemas', 100, 90, 1),
('Protype', 'prototipacao das telas', 100, 70, null),
('Data base', 'criacao do banco de dados', 50, 10, null),
('Teste', 'teste de integração', 80, 20, 2);