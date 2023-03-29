FROM openjdk:11 AS builder
RUN apt-get update -y && apt-get install maven -y
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11
COPY --from=builder /target/tpAchatProject-1.0.jar /app/tpAchatProject-1.0.jar
WORKDIR /app
CMD ["java", "-jar", "tpAchatProject-1.0.jar"]