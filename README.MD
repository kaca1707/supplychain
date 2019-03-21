# Software Design - Supply Chain
An implementation of "Supply Chain" using Spring Boot framework

## Build instructions
```
git clone https://github.com/kaca1707/supplychain.git
cd supplychain
```

On Linux:
```
./mvnw spring-boot:run
```

On Windows:
```
./mvnw.cmd spring-boot:run
```

Go to your webbrowser and type:
```
http://localhost:8080/
```

## Running in IntelliJ
Go to File -> New -> Project from Version Control -> Git -> Paste URL to Git Repo

Go to main class: upm.softwaredesign.finalproject.FinalProjectApplication and start application

## Persistence layer
For now we can use H2 In memory database. 
To go to database type in browser:

``` 
http://localhost:8080/h2-console
```

Use this credentials for dev database:
``` 
JDBC URL: jdbc:h2:~/test
user name: sa
password: 

```