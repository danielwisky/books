FROM eclipse-temurin:18
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.data.mongodb.uri=mongodb://mongodb:27017/books", "-Dspring.kafka.bootstrap-servers=kafka:9092", "/app.jar"]