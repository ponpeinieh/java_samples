:: compile each individual source file
IF exist mods ( rmdir /S /Q mods )
javac -d mods\world src\world\module-info.java src\world\world\World.java
javac -d mods\greetings -p mods src\greetings\module-info.java src\greetings\greetings\Greet.java

