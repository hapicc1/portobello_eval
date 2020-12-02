# portobello
- Projeto 1 - Eval (Camada de integração) - Java springboot
- Projeto 2 - Mock (API de Produto) - Java springboot
- MongoDB - banco de dados Nosql
- RabbitMQ - Mensageria

O serviço Eval Integração está resposável por fazer um GET na API aberta do mercado livre buscando por um produto especifico,
fará esse consulta a cada um minuto e colocará na fila para ser consumido (status:sent) e cadastra mensagem no banco.
Assim que é consumido pelo serviço da fila (status:read) ele envia o produto para ser salvo na API mock e salva status no banco.
algumas informações são printadas no log, como o payload da chamada, status, id e total de mensagens salvas no BD.

## Instruções
- Baixar os projetos
- com docker instalado: vá até a pasta do projeto Eval via linha de comando (cd protobello_eval/eval)
- rodar comando _docker-compose up_ 
esse comando irá subir os containers dos serviços MongoDB e RabbitMQ

### API
após ja ter subido os containers, em outra linha de comando:
- vá até a pasta do projeto mock(api) 
- rodar o comando _mvn clean install_ para instalar as dependencias
- rodar o commando _mvn spring-boot:run_ para subir a aplicação 
(ou pode ser rodado dentro da IDE)

### consultar a api mock
http://localhost:8081
- POST /products - Insere ou Atualiza o produto passado no body
- GET /products - retorna todos os produtos cadastrados
- GET /products/{id} - retorna o produto com id informado
- DELETE /products/{id} - deleta o produto com id informado

### Integração
após ja ter subido os containers e a api, em outra linha de comando:
- vá até a pasta do projeto eval(integracoes) 
- rodar o comando _mvn clean install_ para instalar as dependencias
- rodar o commando _mvn spring-boot:run_ para subir a aplicação 
(ou pode ser rodado dentro da IDE)

