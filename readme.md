This project is about creating the java filter to intecept the request.

##How to configure the project in eclipse
Add below library in the classpath
All the jar from lib folder of the project
java 1.8 - Add java 8 as external folder

## Run on server not showing
1. Right click on the project
2. go to project facets
3. select Dynamic Web Module and Java check boxes
4. Apply and close

## Export as Jar(From eclipse)
1. Right click on the project and select export
2. Select "JAR file" (search if not able to find)
3. Select the following checkboxes
   1. Export all output folders for checked projects
   2. Export java source file and resources
   3. Export refactoring for checked projects
   4. Compress the content of the jar file
5. Select the jar file location
6. Click on Next

## Configure the filter in the tomcat--
1. Add the jar file in the tomcat/lib folder
2. Add below lines in conf/web.xml
	<filter>
    <filter-name>RNT-Filter</filter-name>
    <filter-class>ai.rnt.interceptor.filter.RequestFilter</filter-class>
   </filter>
   <filter-mapping>
		<filter-name>RNT-Filter</filter-name>
		<url-pattern>*</url-pattern>
	</filter-mapping>
3. Restart the server and check if request is going through filter
