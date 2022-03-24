This project is about creating the java filter to intecept the request.

--How to configure the project in eclipse--
Add below library in the classpath
servlet-api.jar - you may get this from tomcat lib folder or from download from web site
java 1.8 - Add java 8 as external folder

--Export the Jar--
1. Right click on the project and select export
2. Select "JAR file" (search if not able to find)
3. Select the jar file location
4. Click on Next

--Configure the filter in the tomcat--
1. Add the jar file in the tomcat/lib folder
2. In ROOT/WEB-INF/web.xml add the following lines
	<filter>
    <filter-name>RNT-Filter</filter-name>
    <filter-class>ai.rnt.filter.RequestFilter</filter-class>
   </filter>
   <filter-mapping>
		<filter-name>RNT-Filter</filter-name>
		<url-pattern>*</url-pattern>
	</filter-mapping>
3. Restart the server and check if request is going through filter
