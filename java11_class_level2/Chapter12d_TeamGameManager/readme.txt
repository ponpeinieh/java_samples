- 將TournamentType的service provider implementation(League與Knockout)分離到自身的module中
- gameapi module中的public API interfaces不需要存在於獨立的module中, 可以被移除掉, 其中的interfaces轉移到competition module中
(原本是為了避免cyclic dependencies)








