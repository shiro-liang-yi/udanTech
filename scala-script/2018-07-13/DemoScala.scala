import scala.util.control.TailCalls._

//class是真正的函数处理处（纯属个人理解）
class DemoScala{
	def isEven(xs:List[Int]):TailRec[Boolean]={
		if(xs.isEmpty){
			done(true)
		}else{
		//交叉调用
			tailcall(isOdd(xs.tail))
		}
	}
	def isOdd(xs:List[Int]):TailRec[Boolean]={
		if(xs.isEmpty){
			done(false)
		}else{
		//交叉调用
			tailcall(isEven(xs.tail))
		}
	}
}
//object是scala程序的入口函数处，要想主动执行scala文件，必须需要（个人理解）
object TestDemo{
	//入口函数的入口方法
	def main(args:Array[String])={
		val demo = new DemoScala
		for(i <- 1 to 5){
			val even = demo.isEven((1 to i).toList).result
			println(s"$i is even? $even")
		}
	}
}