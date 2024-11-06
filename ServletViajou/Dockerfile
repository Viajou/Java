FROM maven:eclipse-temurin AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM tomcat:10.1.28-jdk17

COPY --from=build /app/target/ServletViajou-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh","run"]FROM maven:eclipse-temurin AS build
 
WORKDIR /app
 
COPY pom.xml .
 
RUN mvn dependency:go-offline
 
COPY src ./src
 
RUN mvn clean package -DskipTests
 
FROM tomcat:10.1.28-jdk21

ENV db_conexao=jdbc:postgresql://viajou.cr51xscgnbcy.us-east-1.rds.amazonaws.com:5432/dbviajou
ENV db_usuario=postgres
ENV db_senha=8T7BhtSsDY8iblV98b0A
 
COPY --from=build /app/target/ServletViajou-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ServletViajou.war
