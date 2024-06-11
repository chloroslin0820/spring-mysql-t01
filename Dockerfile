FROM ubuntu:21.04
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$PATH:$JAVA_HOME/bin"

ADD target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]
