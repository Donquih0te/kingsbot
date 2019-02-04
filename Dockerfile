FROM openjdk:11-jdk-slim AS build

WORKDIR /src
COPY ./ /src

RUN gradlew build

FROM openjdk:11-jre-slim AS run

COPY --from=build /build/libs/civ.jar /app/civ.jar

EXPOSE 80

ENTRYPOINT ["java"]
CMD ["-jar", "/app/civ.jar"]