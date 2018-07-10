for{
	x <-  Seq(1,2,2.7,"one","two","four")
}{
	val str = x match{
		case _:Int | _:Double => "a number: "+x
		case "one"            => "string one"
		case _:String         => "other string: "+x
		case _                => "unexpected value: "+x
	}
	println(str)
}

a number:　１　２　２.７ 【×】
string one				 【×】
other string: two four   【×】
a number: 1					【v】
a number" 2					【v】
a number: 2.7				【v】
string one					【v】
other string: two			【v】
other string: four			【v】

