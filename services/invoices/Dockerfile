FROM java:7
MAINTAINER Antonio Drusin, antonio.drusin@gmail.com

WORKDIR /
USER daemon
ADD target/scala-2.11/invoices-assembly-0.1.jar /app/server.jar
ENTRYPOINT [ "java", "-jar", "/app/server.jar" ]

EXPOSE 8080