:: use jimage to see the contents of a JIMAGE file  
IF exist jimage_output.txt (del jimage_output.txt )
jimage list myimage\lib\modules > jimage_output.txt 