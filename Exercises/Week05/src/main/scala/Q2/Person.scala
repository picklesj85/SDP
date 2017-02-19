package Q2

case class Person(firstName: String, lastName: String) {

//  getters not needed in case class
//  def getFirstName = firstName
//  def getLastName = lastName

}
object Person {
  def apply(name: String): Person = {
    val fullName = name.split(" ")
    new Person(fullName(0), fullName(1))
  }
}
