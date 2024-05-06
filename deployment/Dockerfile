FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY *.jar User.jar
ENV JAVA_OPTS=" -Xshareclasses:name=cacheapp,cacheDir=/cache,nonfatal -XX:+UseContainerSupport -XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"
# Replace with a non-root user to avoid running the container with excessive privileges
RUN addgroup --system test
RUN adduser --system testuser --ingroup test

USER testuser:test

ENTRYPOINT [ "sh", "-c", "java -jar User.jar" ]
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS  -jar User.jar" ]

