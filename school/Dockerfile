FROM maven:3.8-eclipse-temurin-21 AS base

WORKDIR /app

COPY . .

RUN mvn clean package -Dmaven.test.skip


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=base /app/target/school-0.0.1-SNAPSHOT.jar school.jar

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD [ "curl", "--fail", "http://localhost:8080/actuator/health" ]

ENTRYPOINT ["java", "-jar", "school.jar"]