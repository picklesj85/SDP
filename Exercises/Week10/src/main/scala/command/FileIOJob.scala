package command

class FileIOJob extends Job {

  private var fileIO: FileIO = _

  def setFileIO(fileIO: FileIO): Unit = this.fileIO = fileIO

  override def run(): Unit = {
    println("Job ID: " + Thread.currentThread().getId + " executing fileIO jobs")
    fileIO.execute()
  }
}