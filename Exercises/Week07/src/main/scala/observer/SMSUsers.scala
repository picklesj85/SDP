package observer

case class SMSUsers(s: Subject, msg: String) extends Observer {

  private var latestUpdate: String = ""


  def update(desc: String) =  {
    latestUpdate = desc
    println(this + " received update: " + latestUpdate)
  }

  def subscribe() = {
    s.subscribeObserver(this)
  }

  def unSubscribe() = {
    s.unSubscribeObserver(this)
  }
}
