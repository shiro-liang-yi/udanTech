//单独只有一个object时，没有main方法时，是运行不了的【说明必须object里面有main方法】
//当然只有一个class文件，而没有object时，也是运行不了的
//始终运行的进入点是object的main方法处
object Test{
	def main(args:Array[String])={
		println("Hello-World-Everyday")
	}
}
