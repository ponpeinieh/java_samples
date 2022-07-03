- 進行top down migration - 針對League.jar, Soccer.jar, Basketball.jar
- 在netbeans中
	- 建立新modular project
	- 建立competition, soccer, basketball, gameapi四個modules
	- competition module包含之前的League.jar内容
	- soccer module包含之前的Soccer.jar内容
	- basketball module包含之前的Basketball.jar内容
	- 爲了避免cyclic dependency, gameapi module將包含League.jar中的Public API, 亦即 Game, GameEvent, GameResult, Player, Team
	- 設定module dependencies
	- 將display-ascii-0.1b.jar 加入到module path將成爲automatic module (加到competition的lib folder)
		- competition module info中加入 requires display.ascii;

	- 爲了避免split package問題, 將soccer與basketball modules中的相同名稱package 'util' 改成不同名稱
	- 最後copy data/authors.txt檔案
- 在Command line中執行 java -p dist;lib -m competition/main.Main

