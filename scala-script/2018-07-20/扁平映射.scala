val list = List("now","is","","the","time")
list flatMap(s => s.toList)

val list3 = List("now","is","","the","time").map(s => s.toList)
list3.flatten

/*
过滤
*/
//如果是var修饰的，引用可变，支持读写
//val修饰的，引用不可变，只能写入一次值，其后只能读
val stateCapitals = Map(
	"Alabama" -> "Montgomery",
	"Alaska" -> "Juneau",
	"Wyoming" -> "Cheyenne"
	)
//添加元素
stateCapitals += ("mm" -> "merry") //此处会报错，因为是val定义的，不支持
//删除元素
stateCapitals -= ("mm" -> "merry")

//是否包含某元素
println(stateCapitals.contains("mm"))
//打印大小
println(stateCapitals.size)
//根据key读取元素，不存在就替换成默认值
println(stateCapitals.get("mm")).getOrElse("default")
//以case形式打印
stateCapitals.foreach{case (e,i) => println(e,i)}
//判断是否为空
println(stateCapitals,isEmpty)
//以键值对格式打印
for((k,v) <- stateCapitals ) println(k,v)
//只打印key
stateCapitals.keys.foreach(println)
//以变量形式打印
for(i <- stateCapitals ) println(i)
//升序排序key
stateCapitals.toSeq.sortBy(_._1)
//升序排序value
stateCapitals.toSeq.sortBy(_._2)
//降序排序key
stateCapitals.toSeq.sortWith(_._1>_._1)
//下面自定义按英文字母或数字排序
implicit  val KeyOrdering=new Ordering[String] {
  override def compare(x: String, y: String): Int = {
	x.compareTo(y)
  }
}
println(stateCapitals.toSeq.sorted)
def main(args: Array[String]) : Unit = {}






























































































