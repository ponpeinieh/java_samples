- 使用service consumer and provider
- 利用proxy 去建立其他的Game, Team, Player等物件
  - 好處:
	- 只需要透過ServiceLoader去建立proxy物件, 然後由proxy去建立Game, Team, Player等物件
  	- Game, Team, Player等物件可以有接受參數的建構子.方便由proxy去呼叫. 
	  否則必須使用no-arg的預設建構子, 並提供方法做後續的屬性設定.

- proxy 為 GameProvider (service interface), 由其去建立Game, Team, Player等物件
  - getType() method來決定GameProvider實作類別(service provider)的型態
- GameProvider實作類別(service provider): SoccerProvider, BasketballProvider
- Factory class中使用ServiceLoader來載入Service providers
- 有了GameProvider proxy物件後再由其來建立Game, Team, Player等物件
- 更新competition module的module-info.java: 
  - uses gameapi.GameProvider;
  - 移除requires soccer; requires basketball;
- 更新soccer module的module-info.java: 
  - provides gameapi.GameProvider with soccer.SoccerProvider;
  - 移除exports soccer;
- 同樣更新basketball module的module-info.java 
- 改寫Factory class, 讓GameProvider物件僅產生一個實體.
- 若沒有找到適當的GameProvider物件, 丟出RuntimeException






