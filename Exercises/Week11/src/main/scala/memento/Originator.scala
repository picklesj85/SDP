package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = {
    println(s"Saving state...$savepointName")
    careTaker.saveMemento(Memento(x, y), savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = {
    println(s"Undo at ...$lastUndoSavepoint")
    x = careTaker.getMemento(lastUndoSavepoint).x
    y = careTaker.getMemento(lastUndoSavepoint).y
  }

  def undo(savepointName: String): Unit = {
    println(s"Undo at ...$savepointName")
    x = careTaker.getMemento(savepointName).x
    y = careTaker.getMemento(savepointName).y
  }

  def undoAll(): Unit = {
    println(s"Undo at ...INITIAL")
    println("Clearing all save points...")
    x = careTaker.getMemento("INITIAL").x
    y = careTaker.getMemento("INITIAL").y
  }

  private def setOriginatorState(savepointName: String): Unit = {
    x = careTaker.getMemento(savepointName).x
    y = careTaker.getMemento(savepointName).y
    lastUndoSavepoint = savepointName
  }

  override def toString(): String = "X: " + x + ", Y: " + y
}
