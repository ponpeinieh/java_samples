:: create a runtime image with launcher
IF exist myimage2 (rmdir /S /Q myimage2)
jlink -p jars;%JAVA_HOME%\jmods --add-modules greeting --launcher Hello=greeting --output myimage2
PAUSE
:: run the launcher
myimage2\bin\Hello.bat
