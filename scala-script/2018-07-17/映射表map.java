val stateCapitals = Map(
	"Alabama" -> "Montgomery",
	"Alaska" -> "Juneau",
	"Wyoming" -> "Cheyenne"
)
val length = stateCapitals map{
	kv => (kv._1,kv._2.length)
}
/*
Scala会在必要的时候将其它类型转为String，由于没有其它更好的选择，+方法
被用于连接两个字符串。
如果一个包含+的表达式返回结果类型是String，而这并不是你所期望的结果。
这可能是因为编译器认为这是该表达式唯一可行的解析方式，
就把+两边的子表达式转为字符串，再相加
*/













