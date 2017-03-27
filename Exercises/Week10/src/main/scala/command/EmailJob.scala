package command

class EmailJob extends Job {

  private var email: Email = _

  def setEmail(email: Email): Unit = this.email = email

  override def run(): Unit = {
    println("Job ID: " + Thread.currentThread().getId + " executing email jobs")
    email.sendEmail()
  }
}