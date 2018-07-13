/*
*	FP解决的问题
*	1）并发的普遍需求，有了并发，我们可以对应用进行水平扩展，并提供其对抗服务器故障的能力。所以，如今并发编程已经是每个开发者的必备技能了
*	2）是编写数据导向程序(如“大数据”)的要求
*/
def factorial(i:Int):Long = {
	def fact(i:Int,accumulator:Int):Long = {
		if(i <= 1) accumulator
		else fact(i-1,i*accumulator)
	}
	fact(i,1)
}
(0 to 5) foreach(i => println(factorial(i)))
1
1
2
6
