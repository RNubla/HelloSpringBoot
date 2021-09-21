# HelloSpringBoot
 Learning to create rest api using kotlin and spring boot

Create a folder called resources under src/main and and create a file called application.properties add the following
```
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@<cluster>.jz2ih.mongodb.net/<database>?retryWrites=true&w=majority
```
application.yml
OR
```
spring:
    data:
        mongodb:
            uri: mongodb+srv://<user>:<password>@<cluster>.jz2ih.mongodb.net
            database: <database>
```
