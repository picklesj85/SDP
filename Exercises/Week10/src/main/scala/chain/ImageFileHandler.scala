package chain

case class ImageFileHandler(s: String) extends Handler {

  private var next = None: Option[Handler]

  override def setHandler(handler: Handler): Unit = {
    next = Some(handler)
  }

  override def process(file: File): Unit = {
    if (file.fileType == "image") {
      println("Process and saving doc file... by " + s)
    } else {
      next match {
        case Some(h) => println(s + " forwards request to " + h.getHandlerName())
                        h.process(file)

        case None => println("File not supported")
      }
    }
  }

  override def getHandlerName(): String = s
}
