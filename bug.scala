```scala
class MyClass[T](val value: T) {
  def myMethod(other: MyClass[T]): T = {
    value + other.value 
  }
}

object Main extends App {
  val num1 = new MyClass(10)
  val num2 = new MyClass(20)
  println(num1.myMethod(num2)) //This will work fine

  val str1 = new MyClass("Hello")
  val str2 = new MyClass(" World")
  println(str1.myMethod(str2)) //This will throw a runtime error if T is String
}
```