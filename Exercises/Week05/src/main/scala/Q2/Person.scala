package Q2

class Person(firstName: String, lastName: String) {

  def getFirstName = firstName
  def getLastName = lastName

}
object Person {
  def apply(name: String): Person = {
    val fullName = name.split(" ")
    new Person(fullName(0), fullName(1))
  }
}
