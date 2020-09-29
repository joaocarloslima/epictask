INSERT INTO users (name, email, pass) VALUES 
('Joao Carlos Lima', 'joaocarlos@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2'),
('Carla Lopes', 'carla@fiap.com.br', '$2a$10$OI52upL5bFKR3xhB.Jv9Ce7gIBt5Cj0qG5R3zZ9VYthdl/eaea1w2');

INSERT INTO tasks (title, description, point, status, user_id) VALUES
('Analise', 'analise completa do sistemas', 100, 90, null),
('Protype', 'prototipacao das telas', 100, 70, 1),
('Data base', 'criacao do banco de dados', 50, 10, null),
('Teste', 'teste de integração', 80, 20, 2);