package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {

  private var liveDescription: String = title


  def subscribeObserver(observer: Observer) =  {
    subscribers += observer
    println(observer + " subscribed.")
  }

  def unSubscribeObserver(observer: Observer) = {
    subscribers -= observer
    println(observer + " unsubscribed.")
  }

  def notifyObservers() =  {
    for (subsciber <- subscribers) {
      subsciber.update(liveDescription)
    }
  }

  def subjectDetails: String = {
    title
  }

  override def setDesc(desc: String): Unit = {
    liveDescription = desc
    notifyObservers()
  }
}
