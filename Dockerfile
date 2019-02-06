FROM openjdk:11

COPY /build/libs/civ.jar /

CMD java -jar /civ.jar