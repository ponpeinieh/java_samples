:: multiple compile 
IF exist mods ( rmdir /S /Q mods )
javac -d mods --module-source-path src src\greetings\greetings\Greet.java
