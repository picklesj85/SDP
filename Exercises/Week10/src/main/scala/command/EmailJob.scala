package command

class EmailJob extends Job {

  private var email: Email = _
  private var id: Int = _

  def setEmail(email: Email) = {
    this.email = email
    EmailJob.id += 1
    id = EmailJob.id
    println("Job ID: " + id + " executing email jobs")
  }

  override def run: Unit = email.sendEmail()
}
object EmailJob {
  var id = 0
}
