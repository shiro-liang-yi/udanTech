/*
	偏应用函数与偏函数
*/
//定义一个带有两个参数列表的方法
def cat1(s1:String)(s2:String)=s1+s2 //cat1: (s1: String)(s2: String)String
//如果我们需要一个专门的版本，要求第一个字符串总是Hello，我们
//可以通过偏应用函数来定义这样的函数
val hello = cat1("Hello")_ //hello: String => String = $$Lambda$1135/1991619042@8b329ae
hello("World!") //res7: String = HelloWorld!
cat1("Hello ")("World!") //res8: String = Hello World!
/*
	关键就在于偏应用函数，对于拥有多个参数列表的函数而言，如果
	你希望忽略其中一个或多个参数列表，可以通过定义一个新函数来实现
	，也就是说，你给出了部分所需的参数。为了避免潜在的表达式歧义，
	scala要求在后面加上下划线，用来告诉编译器你的真实目的
	【注意，这个特性只对函数的多个参数列表有效，对一个参数列表中的多个参数的情况并不适用】
*/

val inverse:PartialFunction[Double,Double]={
	case d if d!=0.0 => 1.0/d
}



















