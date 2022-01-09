FROM alpine:3.14

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk11 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/*

EXPOSE 8080
ADD build/libs/PlantManager-0.0.1-SNAPSHOT.jar plant-manager.jar
ENTRYPOINT ["java", "-jar", "plant-manager.jar"]
