# Back-end (Ubuntu 20.04.1)

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
   CREATE USER quizzer ENCRYPTED PASSWORD 'quiz534';
   ALTER USER quizzer SUPERUSER;
   \c quizzer
   CREATE SCHEMA quizzer;
```

## Jenkins Installing
1. Add the repository key to system:
```bash
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
```

2. Add Debian packages repository address in the server's `source.list`:
```bash
sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
```

3. Update apt:
```bash
sudo apt update
```

4. Install Jenkins and its dependencies:
```bash
sudo apt install jenkins
```

5.Run Jenkins:
```bash
sudo systemctl start jenkins
```

6. Tune the Brandmauer:
```bash
sudo ufw allow 8080
sudo ufw allow OpenSSH
sudo ufw enable
sudo ufw status
````

Possible output result:
```bash
Output
Status: active

To                         Action      From
--                         ------      ----
OpenSSH                    ALLOW       Anywhere
8080                       ALLOW       Anywhere
OpenSSH (v6)               ALLOW       Anywhere (v6)
8080 (v6)                  ALLOW       Anywhere (v6)
```

7. Open Jenkins via browser:
```bash
http://localhost:8080/
```
**Unlock Jenkins** window should be shown.

8. Get the password (32 symbols) to unlock Jenkins:
```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```

9. Copy password and paste it to window's field **Administrator password** -> **Continue** 
   
10. Install **Install suggested plugins** 

11. Create first admin user and finish installing process











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
