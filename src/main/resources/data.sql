INSERT INTO users (name, email, pass, git_hub_user, point) VALUES
('Joao Carlos', 'joao@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'joaocarloslima', 0),
('Carla Lopes', 'carla@gmail.com', '$2a$10$ZXZfITJB56sO8hsHNKIE1uRhn.MRBBxm80TFfAkbd4dfnuydhwiSe', 'carla', 0),
('Fabio Cabrini', 'fabio@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fabio', 20),
('Gabriela Santos', 'gabriela@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fernanda', 100),
('Bianca Souza', 'bianca@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'bianca', 90),
('Andre Matos', 'andre@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'andre', 89),
('Diego Mariano', 'diego@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fernando', 58),
('Ingrid Maia', 'ingrid@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'ingrid', 120),
('Linus Torvalds', 'linus@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'linus', 45),
('Maria das Neves', 'maria@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'mary', 25);

INSERT INTO ROLE (name) values ('ROLE_ADMIN'), ('ROLE_USER'); 

INSERT INTO USERS_ROLES (USERS_ID, ROLES_ID) values 
(1,1), 
(2,2); 


INSERT INTO tasks (title, description, point, status, user_id) VALUES
('Analise', 'analise completa do sistemas', 100, 90, 1),
('Protype', 'prototipacao das telas', 100, 70, null),
('Data base', 'criacao do banco de dados', 50, 10, null),
('Teste', 'teste de integração', 80, 20, 2);