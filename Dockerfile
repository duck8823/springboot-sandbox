FROM maven:3.5.3-jdk-8

ADD . .

ENTRYPOINT ["mvn"]
