FROM tomcat:8.5.50-jdk11-openjdk

MAINTAINER Igor Kuzmin

COPY cloud-publishing-web/cloud-publishing-web-publishing/target/cloud-publishing-web-publishing.war \
cloud-publishing-web/cloud-publishing-rest/employee-rest-service/target/employee-rest-service.war \ 
/usr/local/tomcat/webapps/



EXPOSE 8080