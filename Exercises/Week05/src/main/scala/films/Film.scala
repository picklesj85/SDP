package films

class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {

  def getName = name

  def getYearOfRelease = yearOfRelease

  def getimdbRating = imdbRating

  def getDirector = director

  def directorsAge = yearOfRelease - director.getYearOfBirth

  def isDirectedBy(director: Director) = director == this.director

  def copy(name: String = name, yearOfRelease: Int = yearOfRelease, imdbRating: Double = imdbRating,
           director: Director = director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

  object Film {
    def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) =
      new Film(name, yearOfRelease, imdbRating, director)

    def highestRating(f1: Film, f2: Film) =
      if (f1.getimdbRating > f2.getimdbRating) f1.getimdbRating else f2.getimdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film) =
    if (f1.directorsAge > f2.directorsAge) f1.getDirector else f2.getDirector

}
