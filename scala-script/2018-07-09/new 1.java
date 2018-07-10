//def abs(x:Double) = if(x > 0) x else -x
//for(i <- 1 to 10) yield i%3
def sum(args:Int*){
	//函数得到的是一个类型为Seq的参数
	var result = 0
	for(arg <- args){
		result += arg
		println(result)
	}
}
 sum(1,2,3,4,0)//这样赋值太麻烦了
 //我们可以这样解决：解决的办法就是告诉编译器你希望这个参数被当作参数序列来处理，追加:_*
val s = sum(1 to 5:_*)
