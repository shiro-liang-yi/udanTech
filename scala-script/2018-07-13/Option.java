/*
	get 方法的返回类型是Option（trait）的，因此凡是调用
	get的，如果有值，返回就是Some
	无，就是None
	AnyRef 是引用类型的超类
	Any是基本类型的超类
*/
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
capitals get "France" //注意看返回类型
capitals get "North Pole" //同理
//我定义一个方法
def show(x : Option[AnyRef]) = x match{
	case Some(a) => a
	case None => "?"
}
//调用这个方法
show(capitals get "Japan")

