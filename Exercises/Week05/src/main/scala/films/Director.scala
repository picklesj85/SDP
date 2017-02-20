package films

class Director(firstName: String, lastName: String, yearOfBirth: Int) {

  def name = firstName + " " + lastName

  def getYearOfBirth(): Int = {
    yearOfBirth
  }
}
