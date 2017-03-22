package command

class LoggingJob extends Job {

  private var logging: Logging = _

  def setLogging(logging: Logging) = this.logging = logging

  override def run: Unit = logging.log()
}