# mensageria

Este é um serviço de email que eu criei usando Spring e Gradle! Nesse projeto você encontrará:
- Docker-compose
- Postgres
- Sonarqube
- Jacoco
- Junit
- Lint (spotless)
- Git Actions

Para saber rodar cada (tirando o git actions) estará listado abaixo!!

##Primeira passo:
- Suba o docker-compose com o comando abaixo:
```bash
docker-compose -f docker-compose.yml up
```
##Segundo passo:
- Acesse o banco de dados postgres usando o pgadmin que subiu junto com o docker acessando a URL:
 ```bash
 http://localhost:5050
 ```
- Será pedido uma senha default que será: admin
- Clique em serve com o botão direito e depois Create Server
- Em name coloque Mensageria e depois vá a aba : Connection
    - Hostname: postgres
    - Database: postgres
    - Username: postgres
    - Password: teste
- Com o botão direito clique em mensageria e crie uma database com o nome mensageria



