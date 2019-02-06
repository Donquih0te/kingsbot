FROM openjdk

COPY /gradle/libs/civ.jar .

ENTRYPOINT ["java"]
CMD ["-jar", "/app/civ.jar"]