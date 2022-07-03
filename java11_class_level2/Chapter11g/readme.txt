- 進行 bottom-up migration
- 可以同時使用class path與module path
- 先將display-ascii-0.1b.jar migrate成為 modular library（這個動作在上一步已完成, 可以直接使用）
- 仍舊使用沒有做module migration的League.jar, Soccer.jar, Basketball.jar
- 利用command line來執行
  - java -cp dist/*;lib/Basketball.jar;lib/Soccer.jar -p ../display.ascii/dist main.Main （沒使用--add-module選項,會有錯誤!）
  - java -cp dist/*;lib/Basketball.jar;lib/Soccer.jar -p ../display.ascii/dist --add-modules display.ascii main.Main (使用--add-module選項)
  - java -cp dist/*;lib/Basketball.jar;lib/Soccer.jar -p lib/display-ascii-0.1b.jar  --add-modules display.ascii main.Main (直接用未做migation的display-ascii-0.1b.jar -> automatic module)
- 加上--show-module-resolution選項可以檢視module載入的狀況, --limit-module可以設定要檢視的module
  - java --limit-modules java.base,java.logging --show-module-resolution -cp dist/*;lib/Basketball.jar;lib/Soccer.jar -p lib/display-ascii-0.1b.jar  --add-modules display.ascii main.Main
  - java --limit-modules java.base,java.logging --show-module-resolution -cp dist/*;lib/Basketball.jar;lib/Soccer.jar -p ../display.ascii/dist  --add-modules display.ascii main.Main
- mixed unnamed, automatic, named modules
  - League.jar - loaded on the class path, therefore an unnamed module
  - Basketball.jar - loaded on the class path, therefore an unnamed module
  - Soccer.jar - loaded on the module path therefore an automatic module named Soccer.
  - display.ascii - a named module loaded on the module path
  - java --limit-modules java.base,java.logging --show-module-resolution -cp dist/League.jar;lib/Basketball.jar -p ../display.ascii/dist/;lib/Soccer.jar --add-modules display.ascii,Soccer main.Main









