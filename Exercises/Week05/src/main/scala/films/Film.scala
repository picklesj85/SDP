package films

class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def directorsAge = yearOfRelease - director.getYearOfBirth

  def isDirectedBy(director: Director) = director == this.director
}
