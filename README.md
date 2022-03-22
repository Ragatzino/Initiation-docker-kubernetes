# Initiation Docker Kubernetes

Application spring boot basique pour expérimenter Docker et Kubernetes

## Variables d'environnement configurables 

Exemple pour un Postgres sur localhost:5432:

spring.datasource.url=jdbc:locahost:5432/postgres
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=user
spring.datasource.password=pwd
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# h2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
# init db
spring.jpa.defer-datasource-initialization=true
