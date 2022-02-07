FROM maven:latest

WORKDIR /app
COPY pom.xml /app/pom.xml
COPY src/ /app/src

VOLUME [ "./target:/app/target" ]

RUN mvn -f /app/pom.xml clean compile assembly:single dependency:resolve -P prod

EXPOSE 3456
