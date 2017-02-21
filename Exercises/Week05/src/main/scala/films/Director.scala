package films

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {

  def name = firstName + " " + lastName

}

object Director {
  def older(d1: Director, d2: Director) =
    if (d1.yearOfBirth < d2.yearOfBirth) d1 else d2
}