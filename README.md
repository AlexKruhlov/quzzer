# Back-end

## Database Installing

1. PostgreSQL is used for this project. It's run via docker container. Please, install docker container, pull
   postgres [docker image](https://hub.docker.com/_/postgres)
   and run the docker using following settings:
```bash
   sudo docker container run -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name local_psql postgres
```

2. Open bash terminal connect to container **psql**:
```bash
   sudo docker exec -ti [docker name] bash
   psql -U [user name ("postgres" by default)]
```
   As a result, new line in terminal should be started from `postgres=#`


3. Create a database with **quizzer** name and customize it:
   
```postgresql
   CREATE DATABASE quizzer;
   \c quizzer
   CREATE USER ENCRYPTED PASSWORD 'quiz534';
   ALTER USER quizzer SUPERUSER;
   \c quizzer
   CREATE SCHEMA quizzer;
```

# Front-end

## Node And Angular Installing

1. Install [nvm](https://github.com/nvm-sh/nvm/blob/master/README.md)
2. Install install node - version 14.15.2, using nvm

```bash
nvm i v14.15.2
```

3. Install [angular/cli](https://cli.angular.io/) globally - version 11.0.4

```bash
sudo npm i -g @angular/cli@11.0.4
```
