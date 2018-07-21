class WithFilter(P:A => Boolean){
  def map[B](f:A => B): Option[B] = self filter p map f
  def flatMap[B](f:A => Option[B]): Option[B] = self filter p flatMap f 
  def foreach[U](f:A => U):Unit = self filter p foreach f
  def withFilter(q: A => Boolean) : WithFilter =
    new WithFilter(x => p(x) && q(x))
}

/*
 * 分布式计算中有一个常见的模式：即将计算分解为小任务，再将这些任务分发到急群中，之后再收集这些任务的执行结果
 * */
/**
 *我们希望能通过一种优雅的方式忽略任务结果为空的情况，只对非空结果进行处理，暂且忽略那些出错的任务，首先，假设每个任务都会返回Option对象，其中None对象代表了结果为空的返回值，而Some对象则对非空结果进行了封装。之后，我们希望以最优雅的方式过滤出非空结果。在下面的示例中，有一个包含了三个结果值的集合，其中每个结果值均为Option[Int]对象
 */
val results : Seq[Option[Int]] = Vector(Some(10),None,Some(20))
val results2 = for{
  Some(i) <- results
}yield(2 * i)
//执行结果为：Seq[Int] = Vector(20,40)

//#1
val results2b = for{
  Some(i) <- results withFilter{
    case Some(i) => true
    case None => false
  }
}yield(2 * i)

//#2
val results2c = results withFilter{
  case Some(i) => true
  case None => false
}map{
  case Some(i) => (2 * i)
}

