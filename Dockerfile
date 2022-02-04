FROM adoptopenjdk/maven-openjdk11 as compile-image

RUN mkdir -p /opt/code
WORKDIR /opt/code
COPY . /opt/code

RUN mvn -Dmaven.test.skip clean package

FROM adoptopenjdk/openjdk11:jre-11.0.11_9 as runtime-image
RUN mkdir -p /opt/libs

COPY --from=compile-image /opt/code/infrastructure/target/suburb-infra-0.0.1-SNAPSHOT.jar /opt/libs/
WORKDIR /opt/libs



