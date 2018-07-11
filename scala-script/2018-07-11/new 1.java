object person{
	def apply(name:String, age:Int, address:Address)=
		new Person(name,age,address)
	def unapply(p:Person):Option[Tuple3[String,Int,Address]]=
		Some((p.name,p.age,p.address))
}
//case类的特性就是为了更便捷地进行模式匹配
/*  
	+: 构造操作符可以通过在现有序列前追加新元素来构造新序列。
	我们可以这样凭空开始构造整个序列 
*/
val list = 1 +: 2 +: 3 +: Nil
/*
*	由于 +: 是一个向右结合的操作符，因此我们
	就可以凭空构造出一个列表
	列表、序列、set、map
*/

def processSeq2[T](l:Seq[T]) : Unit = l match{
	case +: (head,tail) =>
		printf("%s +: ",head)
		processSeq2(tail)
	case Nil => print("Nil")
}

val nonEmptyList = List(1,2,3,4,5)
val nonEmptyVector = Vector(1,2,3,4,5)
val nonEmptyMap = Map("one" -> 1, "two"->2, "three"->3)
def reverseSeqToString[T](a:Seq[T]) : String = a match{
	case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
	case Nil => "Nil"
}
for(seq <- Seq(nonEmptyList,nonEmptyVector,nonEmptyMap.toSeq)){
	println(reverseSeqToString(seq))
}
//输出为：
Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
Nil :+ 1 :+ 2 :+ 3 :+ 4 :+ 5
Nil :+ (one,1) :+ (two,2) :+ (three,3)

/* 对于List，用于追加元素的:+方法以及用于模式匹配的:+方法均需要O(n)的时间复杂度
这两个方法都必须要从列表的头部遍历一遍，而对于其他某些序列，如
Vector，则需要O(1)的时间复杂度 */








