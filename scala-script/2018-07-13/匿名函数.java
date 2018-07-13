var factor = 2
val multiplier = (i: Int) => i * factor
(1 to 10) filter(_%2==0) map multiplier reduce(_*_)
factor = 3
(1 to 10) filter(_%2==0) map multiplier reduce(_*_)


def m1(multiplier:Int => Int) = {
	(1 to 10) filter(_%2==0) map multiplier reduce(_*_)
}
def m2: Int => Int={ //m2: Int => Int
	val factor = 2
	val multiplier = (i:Int) => i*factor
	multiplier
}
m1(m2)

//不过你也可以用方法代替函数
object Multiplier{
	var factor = 2
	//Compare: val multiplier=(i:Int)=>i*factor
	def multiplier(i:Int)=i*factor
}
(1 to 10) filter(_%2==0) map Multiplier.multiplier reduce(_*_)
Multiplier.factor=3
(1 to 10) filter(_%2==0) map Multiplier.multiplier reduce(_*_)
/*
	multiplier此时是一个方法。比较一下函数定义与方法定义的语法区别
	除了multiplier是方法以外，我们对它的使用与函数相同，因此他并没有引用this；
	在需要函数的地方用了方法，我们就称该方法被提升为了函数
	“提升”这个词的其他用法我们会在后续章节中继续学习
	
*/







