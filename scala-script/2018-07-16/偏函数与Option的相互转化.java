/*
偏函数与返回Option函数之间是可以相互转化的
这是函数“提升”的另一个用法。
如果我们有一个偏函数，也可以将返回Option的函数“降级”为偏函数
*/
val finicky: PartialFunction[String,String] = {
	case "finicky" => "FINICKY"
}
//finicky: PartialFunction[String,String] = <function1>

finicky("finicky")
//res13: String = FINICK

finicky("other")
//scala.MatchError: other (of class java.lang.String)

//提升为Option
val finickyOption = finicky.lift
//finickyOption: String => Option[String] = <function1>

finickyOption("finicky")
//res14: Option[String] = Some(FINICKY)

finickyOption("other")
//res15: Option[String] = None

//降级为偏函数
val finicky2 = Function.unlift(finickyOption)
//finicky2: PartialFunction[String,String] = <function1>

finicky2("finicky")
//res16: String = FINICKY

finicky2("other")
//scala.MatchError: other (of class java.lang.String) ...



