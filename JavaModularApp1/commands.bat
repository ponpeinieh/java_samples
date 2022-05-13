:: compile each individual source file for each module
IF exist mods ( rmdir /S /Q mods )
javac -d mods\worldmodule src\worldmodule\classes\module-info.java src\worldmodule\classes\com\world\World.java
javac -d mods\hellomodule -p mods src\hellomodule\classes\module-info.java src\hellomodule\classes\com\hello\Hello.java

:: run hellomodule
java -p mods -m hellomodule/com.hello.Hello

:: create module jar files
IF exist jars ( rmdir /S /Q jars )
mkdir jars
jar -c -f jars/worldmodule.jar -C mods/worldmodule .
jar -c -f jars/hellomodule.jar --main-class com.hello.Hello -C mods/hellomodule .

:: run hellomodule with jar 
java -p jars -m hellomodule