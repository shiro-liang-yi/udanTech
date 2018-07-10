模式匹配：从数据结构中提取数据
隐式（implicit）
	-- 减少代码
	-- 向已有类型中注入新的方法
	-- DSL
	
implicit作用一：
def calcTax(amount:Float)(implicit rate:Float) : Float=amount*rate
implicit val currentTaxRate = 0.08F
val tax = calcTax(50000F) //4000.0

implicit作用二：
def calcTax(amount:Float)(implicit rate:Float):Float=amount*rate
object SimpleStateSalesTax{
	implicit val rate:Float=0.05F
}
case class ComplicatedSalesTaxData(
	baseRate:Float,
	isTaxHoliday:Boolean,
	storeId:Int
)
object ComplicatedSalesTax{
	private def extraTaxRateForStore(id:Int):Float={
		//可以通过id推断处商铺所在地，之后再计算附加税
		0.0F
	} 
	implicit def rate(implicit cstd:ComplicatedSalesTaxData):Float=
		if(cstd.isTaxHoliday) 0.0F
		else cstd.baseRate + extraTaxRateForStore(cstd.storeId)
}
{
	import SimpleStateSalesTax.rate
	val amount = 100F
	println(s"Tax on $amount = ${calcTax(amount)}")
}
{
	import ComplicatedSalesTax.rate
	implicit val myStore = ComplicatedSalesTaxData(0.06F,false,1010)
	val amount = 100F
	println(s"Tax on $amount = ${calcTax(amount)}")
}

/* 有些集合提供了一些排序方法，List.sortBy便是其中之一。List.sortBy方法的第一个参数
类型为函数，该输入函数能够将函数的输入参数转化为另一个满足math.Ordering条件的类型。
Li st.sortBy方法的另一个参数为隐式参数，该参数知道如何对类型B的实例进行排序 */
 
apply[T](body: => T)(implicit executor:ExecutionContext):Future[T]
import _.concurrent.ExecutionContext.Implicits.global

其实implicit的使用，之所以它能够减少同样业务代码量，是依赖于其：能够推断上下文中的implicit
因此功能一：传递上下文对象
	功能二：控制系统功能

//假设你想要创建用户界面的菜单，其中某些菜单项只对已登录用户可见，
//而其他菜单项仅对未登录用户可见
def createMenu(implicit session:Session):Menu={
	val defaultItems = List(helpItem,searchItem)
	val accountItems =
		if(session.loggedin()) List(viewAccountItem,editAccountItem)
		else List(loginItem)
	Menu(defaultItems ++ accountItems)
}
//函数式编程语言中，非常不建议你使用return（但不禁用）

//设想一下，我们希望对具有可参数化类型方法中的类型参数进行限定，使该参数只接受某些类型的输入。那么该如何处理呢：
//假如允许输入的所有参数类型均为某一公共超类的字类型，那么无需应用隐式技术，面向对象的技术便可解决这一问题
[-A]
trait TraversableOnce[+A] ...{
	def toMap[T,U](implicit ev: <:<[A,(T,U)]):immutable.Map[T,U]	
}
/* 隐式参数ev便是我们的”证据“，它代表了我们必须实施的约束。ev运用了Predef中定义的名为<:<的类型，该名字取自于<:方法。<:方法同样也被用于限定类型参数，
例如：A<:B
我们曾提及过，可以使用中缀表示法表示由两个类型参数所组成的类型，
因此下列两种表达式是等价的
			<:<[A,B]
			A <:< B */

	
	
	
	
	
	

