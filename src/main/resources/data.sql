INSERT INTO users (name, email, pass, git_hub_user, point) VALUES 
('Joao Carlos Lima', 'joaocarlos@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'joaocarloslima', 0),
('Carla Lopes', 'carla@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'carla', 100),
('Fabio Cabrini', 'fabio@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fabio', 10),
('Gabriela Santos', 'gabriela@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fernanda', 50),
('Bianca Souza', 'bianca@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'bianca', 40),
('Andre Matos', 'andre@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'andre', 60),
('Diego Mariano', 'diego@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'fernando', 70),
('Ingrid Maia', 'ingrid@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'ingrid', 90),
('Linus Torvalds', 'linus@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'linus', 85),
('Maria das Neves', 'maria@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2', 'mary', 110);
INSERT INTO ROLE(name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO USERS_ROLES(USERS_ID, ROLES_ID) VALUES (1, 1), (2,2);

INSERT INTO tasks (title, description, point, status, user_id) VALUES
('Analise', 'analise completa do sistemas', 100, 90, null),
('Prototype', 'prototipacao das telas', 100, 70, 1),
('Database', 'criacao do banco de dados', 50, 10, null),
('Teste', 'teste de integração', 80, 20, 2);