FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/testarchitectureDocker

# ADD .jar under target from host
ADD target/testarchitecture.jar          testarchitecture.jar
ADD target/testarchitecture-tests.jar    testarchitecture-tests.jar
ADD target/libs                         libs

#in case of any other dependecy like .csv/ .json / .xls
# please ADD that as well

#ADD suite file
ADD ui-module.xml                   ui-module.xml
ADD api-module.xml                  api-module.xml
ADD db-module.xml                   db-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh

#BROWSER
#HUB_HOST
#MODULE
#ENTRYPOINT sh healthcheck.sh
ENTRYPOINT java -cp testarchitecture.jar:testarchitecture-tests.jar:libs/* -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE