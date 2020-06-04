# Apache-Tomcat-MongoDB-Remote-Code-Execution

#### 0x01 add the following JARs to lib/ directory

```
mongo-java-driver-3.10.2.jar
mongo-store-3.0.0.jar
Mongo-Tomcat-Sessions.jar
```

#### 0x02 modify the configuration file, `` conf/context.xml ``

```
<Valve className="com.dawsonsystems.session.MongoSessionTrackerValve"/>
<Manager className="com.dawsonsystems.session.MongoManager" 
         host="127.0.0.1" 
         port="27017" 
         database="sessions" 
         maxInactiveInterval="84"/>
```
#### 0x03 start Tomcat Server, when users login the website, their login sessions will be stored in MongoDB, as you know, there are so many unauthorized MongoDB Servers on the Internet.



#### 0x04 send the request with PoC, when users login again, the Remote Code Executed.

[<img src="http://www.google.com.au/images/nav_logo7.png">](http://google.com.au/)
