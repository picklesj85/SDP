package command

class FileIOJob extends Job {

  private var fileIO: FileIO = _

  def setFileIO(fileIO: FileIO) = this.fileIO = fileIO

  override def run: Unit = fileIO.executeFileIO()
}
