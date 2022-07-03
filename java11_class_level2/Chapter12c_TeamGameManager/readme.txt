- 增加更多的service consumer and provider
- 增加Competition types - League之外加上Knockout
- Service provider不需要使用proxy, 因為只有一個物件要產生(TournamentType)
- 在TournamentFactory中利用ServiceLoader來載入TournamentType
  - TournamentType的實作類別必須有no-arg建構子, 並且提供例如populate()方法來做後續的屬性建置(例如teams, games等)
- 實作TournamentType的類別包括League, Knockout
- competition module除了是TournamentType的service consumer也是service provider (亦即competition module包含了League與Knockout)








