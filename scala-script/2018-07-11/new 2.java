/*
类型类模式
*/
/* Scala作为一门JVM语言，也继承了Java中无所不在的Object.toString方法。
Scala在case类中使用的语法则不同，该语法更加有用，也更具可读性；
有时候打印出像json或xml样的具有机器可读性的格式是很有价值的。
通过隐式转换，我们可以为任何类型添加toJson和toXML方法；
如果对象中定义toString方法，我们也能通过隐式转换定义该方法
Haskell语言中的类型类能定义等价于接口的类型，
之后我们便能实现各种具体类型；
Scala中的类型类模式（type class pattern）新增了接口部分，
这一功能是之前的隐式转换示例所未提供的；让我们阅读一下toJSON类型类的某一实现
 */
case class Address(street:String,city:String)
case class Person(name:String,address:Address)
trait ToJSON {
	def toJSON(level: Int = 0): String
	val INDENTATION = " "
	def indentation(level: Int = 0): (String,String) =
	(INDENTATION * level, INDENTATION * (level+1))
}
implicit class AddressToJSON(address: Address) extends ToJSON {
	def toJSON(level: Int = 0): String = {
	val (outdent, indent) = indentation(level)
	s"""{
		|${indent}"street": "${address.street}",
		|${indent}"city": "${address.city}"
		|$outdent}""".stripMargin
	}
}
implicit class PersonToJSON(person: Person) extends ToJSON {
	def toJSON(level: Int = 0): String = {
	val (outdent, indent) = indentation(level)
	s"""{
		|${indent}"name": "${person.name}",
		|${indent}"address": ${person.address.toJSON(level + 1)}
		|$outdent}""".stripMargin
	}
}
	val a = Address("1 Scala Lane", "Anytown")
	val p = Person("Buck Trends", a)
	println(a.toJSON())
	println()
	println(p.toJSON())


