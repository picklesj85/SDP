package films

class Director(firstName: String, lastName: String, yearOfBirth: Int) {

  def name = firstName + " " + lastName

  def getYearOfBirth(): Int = {
    yearOfBirth
  }
}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) =
    new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director) =
    if (d1.getYearOfBirth() < d2.getYearOfBirth()) d1 else d2

}