# custom-scdf
a custom build of spring cloud dataflow server with security switched to basic auth instead of OAuth2.

1. adjust the cloudfounry credentials/details in `application.yml` for you env

2. start database with 

```
cd local-env
docker-compose up -d
```

3. run app

```
mvn spring-boot:run
```

4. login to http://localhost:8888/dashboard - there are two hard coded users with a password, both have the same permissions:

    `admin / password`
    
    `user / password`

## current issues

- flyway can't find the migration files.

  if `spring.flyway.enabled` is set to `true`, then flyway fails with the following error:

```
Caused by: java.lang.IllegalStateException: Cannot find migrations location in: [classpath:db/migration] (please add migrations or check your Flyway configuration)
    at org.springframework.util.Assert.state (Assert.java:94)
    at org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration$FlywayConfiguration.checkLocationExists (FlywayAutoConfiguration.java:184)
    at org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration$FlywayConfiguration.flyway (FlywayAutoConfiguration.java:149)
    at org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration$FlywayConfiguration$$EnhancerBySpringCGLIB$$5825e195.CGLIB$flyway$0 (<generated>)
```

- ClassNotFoundException: `org.springframework.cloud.deployer.spi.cloudfoundry.CloudFoundry2630AndLaterTaskLauncher`

  if `spring.flyway.enabled` is set to `false` (e.g. we could create the tables in some other way), then we get passt the flyway issue, but we get the following error:
  
```
Caused by: java.lang.ClassNotFoundException: org.springframework.cloud.deployer.spi.cloudfoundry.CloudFoundry2630AndLaterTaskLauncher
    at java.net.URLClassLoader.findClass (URLClassLoader.java:471)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:588)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:521)
    at java.lang.Class.getDeclaredMethods0 (Native Method)
    at java.lang.Class.privateGetDeclaredMethods (Class.java:3167)
    at java.lang.Class.getDeclaredMethods (Class.java:2310)
    at org.springframework.util.ReflectionUtils.getDeclaredMethods (ReflectionUtils.java:489)
    at org.springframework.util.ReflectionUtils.doWithLocalMethods (ReflectionUtils.java:367)
```



