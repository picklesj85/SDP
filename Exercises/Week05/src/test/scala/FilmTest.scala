import org.scalatest.FunSuite
import films._

class FilmTest extends FunSuite {
  val sergioLeone = new Director("Sergio", "Leone", 1922)
  val film = new Film("A Fistful of Dollars", 1972, 7.8, sergioLeone)

  test("getting director's name") {
    assert(sergioLeone.name == "Sergio Leone")
  }

  test("Get director's age") {
    assert(sergioLeone.getYearOfBirth() == 1922)
  }

  test("get film name") {
    assert(film.getName == "A Fistful of Dollars")
  }

  test("get imdb rating") {
    assert(film.getimdbRating == 7.8)
  }

  test("get year of release") {
    assert(film.getYearOfRelease == 1972)
  }

  test("get director's age") {
    assert(film.directorsAge == 50)
  }

  test("is directed by ") {
    assert(film.isDirectedBy(sergioLeone))
  }

  test("direct copy") {
    val copy = film.copy()
    assert(copy.getName == "A Fistful of Dollars")
    assert(copy.getYearOfRelease == 1972)
    assert(copy.getimdbRating == 7.8)
    assert(copy.isDirectedBy(sergioLeone))
    assert(copy != film)
  }

  test("copy change imdb rating") {
    val copy = film.copy(imdbRating = 8.9)
    assert(copy.getName == "A Fistful of Dollars")
    assert(copy.getYearOfRelease == 1972)
    assert(copy.getimdbRating == 8.9)
    assert(copy.isDirectedBy(sergioLeone))
  }

  test("copy with new director") {
    val copy = film.copy(director = new Director("JJ", "Abrams", 1979))
    assert(copy.getName == "A Fistful of Dollars")
    assert(copy.getYearOfRelease == 1972)
    assert(copy.getimdbRating == 7.8)
    assert(!copy.isDirectedBy(sergioLeone))
    assert(copy.directorsAge == -7)
  }

  test("copy change everything") {
    val copy = film.copy(name = "Star Wars", yearOfRelease = 2016, imdbRating = 8.0, director = new Director("JJ", "Abrams", 1979))
    assert(copy.getName != film.getName)
    assert(copy.getYearOfRelease != film.getYearOfRelease)
    assert(copy.getimdbRating != film.getimdbRating)
    assert(!copy.isDirectedBy(sergioLeone))
    assert(copy.directorsAge == 37)
  }

  test("multiple copy") {
    val copy = film.copy().copy().copy().copy()
    assert(copy.getName == "A Fistful of Dollars")
    assert(copy.getYearOfRelease == 1972)
    assert(copy.getimdbRating == 7.8)
    assert(copy.isDirectedBy(sergioLeone))
    assert(copy != film)
  }

}
