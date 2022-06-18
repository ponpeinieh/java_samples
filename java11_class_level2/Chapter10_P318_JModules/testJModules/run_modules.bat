:: run module
java --module-path jars --module greeting
java -p jars -m greeting
java -p jars -m greeting/greeting.Hello
java -p mods -m greeting/greeting.Hello