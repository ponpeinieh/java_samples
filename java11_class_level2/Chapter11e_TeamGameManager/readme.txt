- 進一步將competition中的main分離出來到另一個module 'main'
	- competition module 代表public API, main module 為competition API的使用者 
- PlayerDatabase也移到main module中
- main module 只是以爲使用competition module 而間接使用gameapi, 所以可以 利用transitive dependency來簡化依賴關係
	- competition的module info中使用 requires transitive gameapi;
	- main 的module info中移除 requires gameapi;
- soccer module 僅 exports給competition module (basketball module亦同)


