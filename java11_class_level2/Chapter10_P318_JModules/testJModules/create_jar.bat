:: create module jar files
IF exist jars ( rmdir /S /Q jars )
mkdir jars
jar --create -f jars/world.jar -C mods/world .
jar --create -f jars/greeting.jar --main-class greeting.Hello -C mods/greeting .