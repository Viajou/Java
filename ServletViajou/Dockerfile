# Estágio de build com Maven e JDK 21
FROM maven:3.8.3-openjdk-21 AS build
WORKDIR /app

# Copia os arquivos necessários
COPY pom.xml .
COPY src ./src

# Compila o projeto sem executar os testes
RUN mvn clean package -DskipTests

# Estágio final com Tomcat 10 e JDK 21
FROM tomcat:10.1.19-jdk21

# Configura a porta do Tomcat para a porta padrão do Render (10000)
RUN sed -i 's/8080/10000/g' /usr/local/tomcat/conf/server.xml

# Copia o WAR gerado no build para a pasta webapps do Tomcat
COPY --from=build /app/target/ServletViajou-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/app.war

# Expondo a porta padrão do Render
EXPOSE 10000

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]
