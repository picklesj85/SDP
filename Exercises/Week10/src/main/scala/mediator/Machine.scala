package mediator

class Machine extends Colleague {

  private var mediator: MachineMediator = _

  override def setMediator(mediator: MachineMediator): Unit = {
    this.mediator = mediator
  }

  def start(): Unit = {
    mediator.open()
    mediator.closed()
    mediator.on()
    mediator.off()
    wash()
  }

  def wash(): Unit = mediator.wash()
}