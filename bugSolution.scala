```scala
trait Addable[T] {
  def add(x: T, y: T): T
}

object AddableInstances {
  implicit val intAddable: Addable[Int] = new Addable[Int] {
    override def add(x: Int, y: Int): Int = x + y
  }
  implicit val stringAddable: Addable[String] = new Addable[String] {
    override def add(x: String, y: String): String = x + y
  }
}

class MyClass[T](val value: T)(implicit val adder: Addable[T]) {
  def myMethod(other: MyClass[T]): T = {
    adder.add(value, other.value)
  }
}

object Main extends App {
  import AddableInstances._
  val num1 = new MyClass(10)
  val num2 = new MyClass(20)
  println(num1.myMethod(num2)) // Output: 30

  val str1 = new MyClass("Hello")
  val str2 = new MyClass(" World")
  println(str1.myMethod(str2)) // Output: Hello World
}
```