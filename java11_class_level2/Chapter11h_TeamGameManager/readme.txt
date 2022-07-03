- 加入Jackson Library , 用來將物件內容轉換成JSON格式做儲存
- 將來可以改變不同的儲存方式, 例如SQL Database, XML檔案等
- 建立storage module
  - 建立storage package
  - 將Jackson library jars加入到storage module的libraries中, nb會自動將這些module dependencies 加入module-info.java中
	- requires jackson.annotations;
    	- requires jackson.core;
    	- requires jackson.databind;
  - module-info.java中加入 
	- requires gameapi;
	- exports storage;
  - Main module 
	- module-info.java中加入requires storage;
	- Main class加入code, 使用jackson libraries將game objects轉成JSON儲存
	- 執行時會產生錯誤, 因為Jackson libraries(jackson.databind module)使用reflection機制讀取物件的private fields內容, 因此必須加入opens 宣告
	  - opens soccer to jackson.databind;
	- Main class也加入code, 使用jackson libraries將JSON還原回game objects
	- League加入新的建構子, 可以從還原的Game object array建構League物件
	  - Main class中使用新建構的League物件





