/* 
尾部调用和尾部调用优化
在尾递归中，函数可以调用自身，并且该调用是函数的最后一个（‘尾部’）操作
。尾递归非常重要，因为这是能把函数优化为循环的最重要的一种递归。
循环可以消除潜在的栈溢出风险，同时也因为消除了函数调用开销而提升效率

 */
import scala.util.control.TailCalls._
def isEven(xs:List[Int]):TailRec[Boolean]={
	if(xs.isEmpty){
		done(true)
	}else{
		tailcall(isOdd(xs.tail))
	}
}
def isOdd(xs:List[Int]):TailRec[Boolean]={
	if(xs.isEmpty){
		done(false)
	}else{
		tailcall(isEven(xs.tail))
	}
}

for(i <- 1 to 5){
	val even = isEven((1 to i).toList).result
	println(s"$i is even? $even")
}










