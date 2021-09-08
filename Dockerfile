FROM gradle:jdk11 AS build

WORKDIR /build

COPY build.gradle settings.gradle .
COPY src src
RUN gradle --no-daemon bootJar


FROM openjdk:11-jre-slim

ARG PROJECT=jclo-7-2-1
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /app
COPY --from=build /build/build/libs/${PROJECT}-${VERSION}.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
