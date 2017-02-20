package films

class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def getName = name

  def getYearOfRelease = yearOfRelease

  def getimdbRating = imdbRating

  def directorsAge = yearOfRelease - director.getYearOfBirth

  def isDirectedBy(director: Director) = director == this.director

  def copy(name: String = name, yearOfRelease: Int = yearOfRelease, imdbRating: Double = imdbRating,
           director: Director = director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}
