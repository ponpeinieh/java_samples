:: multiple compile 
IF exist mods ( rmdir /S /Q mods )
javac -d mods --module-source-path src src\greeting\greeting\Hello.java
