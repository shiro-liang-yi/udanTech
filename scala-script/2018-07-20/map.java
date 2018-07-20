/*
scala 中的 map
*/
var a : Map[String,String] = Map(
	"one" -> "1",
	"two" -> "2",
	"three" -> "3"
)
a += "four" -> "4"

scala> for((k,v) <- a) println(k,v)
(one,1)
(two,2)
(three,3)
(four,4)

scala> for((k,v) <- a) println((k,v))
(one,1)
(two,2)
(three,3)
(four,4)

scala> a += "2" -> "3"

scala> a.keys.foreach(println)
four
three
two
2
one

scala> a -= ("2")

scala> println(a.contains("s"))
false

scala> println(a.get("one").getOrElse("default"))
1

scala> a.toSeq.sortBy(_._1)
res17: Seq[(String, String)] = Vector((four,4), (one,1), (three,3), (two,2))

scala> a.toSeq.sortWith(_._1<_._1)
res20: Seq[(String, String)] = Vector((four,4), (one,1), (three,3), (two,2))
