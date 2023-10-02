Types of Module:
----------------
Modules can be defined into three types:

1. Named Module
    1. This is also called as an explicit module.
    2. No need of explicitly specifying the "java.base" from JDK modules as it is implicitly added.
    3. If one module is dependent on another then it needs to be specified in the module-info.
2. Unnamed Module
    1. Code reads every other module.
    2. exports all the features which enables flexible migration.
    3. This is run using the classpath command "java -cp".
3. Automatic Module
    1. It is the middle ground between named and unnamed module.
    2. This came into picture for the below use case.
        * Suppose we have jar file app.jar which is dependent on an external third party jar.
        * We want to migrate the app.jar to modular app, but the third party jar is not owned by us, and it does not
          support modular system.
        * The issue here is "Named/Explicit module cannot declare a dependence on unnamed module". This will prevent
          making the app.jar modular.
        * To fix this automatic module came into picture where was the third part an automatic module package is created
          whose name is the jat name with underscore(_) replaced with period(.).
        * Now this can be imported in the app.jar module.
    3. This is run using the module path(java -p).