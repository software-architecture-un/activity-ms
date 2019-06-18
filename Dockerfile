FROM javergarav/tomee

COPY env/tomee.xml conf/tomee.xml
COPY env/server.xml conf/server.xml

COPY target/activities-ms.war webapps/activities-ms.war
EXPOSE 4000
EXPOSE 3306
