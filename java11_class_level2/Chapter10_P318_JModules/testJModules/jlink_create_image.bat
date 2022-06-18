:: jlink to create a runtime image
IF exist myimage (rmdir /S /Q myimage)
jlink --module-path jars;%JAVA_HOME%\jmods --add-modules greeting --output myimage