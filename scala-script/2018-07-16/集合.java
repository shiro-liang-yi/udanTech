val products = zipped map{
	case (x,y) => x*y
}
WrapAsJava	WrapAsScala
import scala.collection.JavaConversions
/*对容器执行排序是非常常见的操作，因此Scala提供了一些Ordering[T]
类型的隐式值
其中T是一个String类型值，String类型是一类AnyVal类型，可以转换成
Numeric类
*/

/*
函数式编程，返回Unit的函数只能执行带副作用的操作，它必须在某处对
可变状态做修改。一个例子就是调用了println或printf去打印the worlld
字符串的函数，它将某个i/o相关状态修改为the world
当一个函数采用其他函数作为变量或返回值时，它被称为高阶函数
其实函数的最后返回值都可以用一个变量来接收值
但是方法基本就是自然返回
*/
