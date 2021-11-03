Faça o Clone: git clone https://github.com/Bruno-Henrique-BR/api-customer.git

Roda o script no postgreSQL CREATE DATABASE db;

Se a porta não for a padrão 5432, abra o arquivo application.properties e 
mude a linha spring.datasource.url = jdbc:postgresql://localhost:5432/bd,  para a porta que usa.

Logo em seguida abra e suba a aplicação na ide intellij

E por para subir a documetação da api basta acessar http://localhost:8080/swagger-ui.html
