Tecnologias utilizadas no projeto:
- java 11
- Springboot 2.7.5 
- Apache Camel 3.19
- Lombok

Projeto criado com intuito de realizar estudo e uma apresentação para a squad.
Utilizado o Apache Camel para importar arquivos .csv e transforma-los em .json

Rodar o projeto
- disparar o endpoint @POST http://localhost:8080/importer/start sem body e autenticação 
para que seja iniciado a importação da pasta "Entradas" e processado para a pasta "Saidas". 