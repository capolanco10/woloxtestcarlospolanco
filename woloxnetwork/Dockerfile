FROM openjdk:8
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} woloxnetwork-1.0.0.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "woloxnetwork-1.0.0.jar"]
