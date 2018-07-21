class WithFilter(P:A => Boolean){
  def map[B](f:A => B): Option[B] = self filter p map f
  def flatMap[B](f:A => Option[B]): Option[B] = self filter p flatMap f 
  def foreach[U](f:A => U):Unit = self filter p foreach f
  def withFilter(q: A => Boolean) : WithFilter =
    new WithFilter(x => p(x) && q(x))
}

/*
 * �ֲ�ʽ��������һ��������ģʽ����������ֽ�ΪС�����ٽ���Щ����ַ�����Ⱥ�У�֮�����ռ���Щ�����ִ�н��
 * */
/**
 *����ϣ����ͨ��һ�����ŵķ�ʽ����������Ϊ�յ������ֻ�Էǿս�����д������Һ�����Щ������������ȣ�����ÿ�����񶼻᷵��Option��������None��������˽��Ϊ�յķ���ֵ����Some������Էǿս�������˷�װ��֮������ϣ���������ŵķ�ʽ���˳��ǿս�����������ʾ���У���һ���������������ֵ�ļ��ϣ�����ÿ�����ֵ��ΪOption[Int]����
 */
val results : Seq[Option[Int]] = Vector(Some(10),None,Some(20))
val results2 = for{
  Some(i) <- results
}yield(2 * i)
//ִ�н��Ϊ��Seq[Int] = Vector(20,40)

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

