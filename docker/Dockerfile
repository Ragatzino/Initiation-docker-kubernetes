FROM tomcat:9-jre11
EXPOSE 8080
COPY target/*.war $CATALINA_HOME/webapps/
CMD ["catalina.sh","run"]
