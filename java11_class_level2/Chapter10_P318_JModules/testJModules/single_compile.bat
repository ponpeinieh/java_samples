:: compile each individual source file
IF exist mods ( rmdir /S /Q mods )
javac -d mods\world src\world\module-info.java src\world\world\World.java
javac -d mods\greeting -p mods src\greeting\module-info.java src\greeting\greeting\Hello.java

