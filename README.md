spring-mvc-logger
=================
1. Add to pom.xml

```   
   <dependency>
        <groupId>com.github.isrsal</groupId>
        <artifactId>spring-mvc-logger</artifactId>
        <version>0.1</version>
    </dependency>
```

2. Add to web.xml

```
    <filter>
        <filter-name>loggingFilter</filter-name>
        <filter-class>org.isrsal.logging.LoggingFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>loggingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

3. Add to log4j.xml

```
   <logger name="org.isrsal.logging.LoggingFilter">
      <level value="DEBUG"/>
   </logger>
```
