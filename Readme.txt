This is a test project called ciatPartners

The application let users view and register the request for additions of partners.

All records are stored in a text file called partners.txt. 

This file will be created if not exists in the user directory of the environment where ciatPartners will be deploy or run (typically c:\Users\PC-Name).

The project was created using the following technologies:

Server: apache-tomcat-7.0.76 

Source code:
Java, version 1.8.0 update 21
Apache maven, version 3.3.9
Struts2 framework, version 2.5.10.1
GIT, version 2.12.2 for Windows S.O.

To run the project just type the following commands:

1. >> mvn clean package 
2. >> mvn mvn tomcat7:deploy

Additionally you can use the next use uselful commands:

	>> mvn tomcat7:undeploy
	>> mvn tomcat7:redeploy 

Thank you!

