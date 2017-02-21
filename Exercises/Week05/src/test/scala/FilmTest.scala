import org.scalatest.FunSuite
import films._

class FilmTest extends FunSuite {
  val sergioLeone = new Director("Sergio", "Leone", 1922)
  val film = new Film("A Fistful of Dollars", 1972, 7.8, sergioLeone)

  test("getting director's name") {
    assert(sergioLeone.name == "Sergio Leone")
  }

  test("Get director's age") {
    assert(sergioLeone.yearOfBirth == 1922)
  }

  test("get film name") {
    assert(film.name == "A Fistful of Dollars")
  }

  test("get imdb rating") {
    assert(film.imdbRating == 7.8)
  }

  test("get year of release") {
    assert(film.yearOfRelease == 1972)
  }

  test("get director's age") {
    assert(film.directorsAge == 50)
  }

  test("is directed by ") {
    assert(film.isDirectedBy(sergioLeone))
  }

  test("direct copy") {
    val copy = film.copy()
    assert(copy.name == "A Fistful of Dollars")
    assert(copy.yearOfRelease == 1972)
    assert(copy.imdbRating == 7.8)
    assert(copy.isDirectedBy(sergioLeone))
    assert(copy ne film)
  }

  test("copy change imdb rating") {
    val copy = film.copy(imdbRating = 8.9)
    assert(copy.name == "A Fistful of Dollars")
    assert(copy.yearOfRelease == 1972)
    assert(copy.imdbRating == 8.9)
    assert(copy.isDirectedBy(sergioLeone))
  }

  test("copy with new director") {
    val copy = film.copy(director = new Director("JJ", "Abrams", 1979))
    assert(copy.name == "A Fistful of Dollars")
    assert(copy.yearOfRelease == 1972)
    assert(copy.imdbRating == 7.8)
    assert(!copy.isDirectedBy(sergioLeone))
    assert(copy.directorsAge == -7)
  }

  test("copy change everything") {
    val copy = film.copy(name = "Star Wars", yearOfRelease = 2016, imdbRating = 8.0, director = new Director("JJ", "Abrams", 1979))
    assert(copy.name != film.name)
    assert(copy.yearOfRelease != film.yearOfRelease)
    assert(copy.imdbRating != film.imdbRating)
    assert(!copy.isDirectedBy(sergioLeone))
    assert(copy.directorsAge == 37)
  }

  test("multiple copy") {
    val copy = film.copy().copy().copy().copy()
    assert(copy.name == "A Fistful of Dollars")
    assert(copy.yearOfRelease == 1972)
    assert(copy.imdbRating == 7.8)
    assert(copy.isDirectedBy(sergioLeone))
    assert(copy ne film)
  }

  test("director apply method") {
    val d = Director("Steven", "Spielberg", 1950)
    assert(d.yearOfBirth == 1950)
    assert(d.name == "Steven Spielberg")
  }

  test("older") {
    val d = Director("Martin", "Scorecese", 1943)
    val d2 = Director("Alfred", "Hitchcock", 1914)
    assert(Director.older(d, d2) == d2)
    assert(Director.older(sergioLeone, d) == sergioLeone)
  }

  test("highestRating") {
    val f = Film("Star Wars", 2016, 8.0, new Director("JJ", "Abrams", 1979))
    assert(Film.highestRating(film, f) == 8.0)
  }

  test("oldest director at the time") {
    val f = Film("Star Wars", 2016, 8.0, new Director("JJ", "Abrams", 1979))
    assert(Film.oldestDirectorAtTheTime(film, f) == sergioLeone)
  }

}
