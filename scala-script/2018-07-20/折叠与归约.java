/*
折叠与归约：它们都是将一个集合“缩小”成一个更小的集合或一个值的操作
*/
val list:List[Int] = List(1,2,3,4,5,6)
//因为scala的类型推导简写为 val list=List(1,2,3,4,5,6)
list reduce(_ + _) //res0: Int = 21
list.fold(10)(_*_) //res1: Int = 7200
(list fold 10)(_ * _) //res1: Int = 7200
/*
以上脚本通过累加各个元素，将整数列表归约为一个整数值，返回值为21；
脚本接着用10作为初始值，对同一个列表的元素做累乘，得到值7200
与reduce类似，传给fold的函数需要两个参数，包括累计值和初始值；
新的累计值由该函数计算得到。
*/
val fold1 = (list fold 10) _
fold1(_ * _)

(List(1,2,3,4,5,6) foldRight List.empty[String]){
	(x,list) => ("[" + x + "]") :: list
}












