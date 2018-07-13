/*
递归，在函数式编程中递归是实现“循环”的唯一方法
下面这个例子，分别用java和scala实现阶乘
*/
public class Factorial{
	public static long factorial(long l){
		long result = 1L;
		for(long j=2L;j<=l;j++){
			result *= j;
		}
		return result;
	}
}
public static void main(String args[]){
	for(long l=1L;l<=10;l++){
		System.out.printf("%d:\t%d\n",l,factorial(l));
	}
}

//下面用scala递归实现
import scala.annotation.tailrec
//@tailrec用来识别一个函数是否是尾递归
def factorial(i:BigInt):BigInt = {
	if(i==1) i
	else i*factorial(i-1)
}
for(i <- 1 to 10) println(s"$i:\t${factorial(i)}")
	