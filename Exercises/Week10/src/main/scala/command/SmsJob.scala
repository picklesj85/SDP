package command

class SmsJob extends Job {

  private var sms: Sms = _

  def setSms(sms: Sms): Unit = this.sms = sms

  override def run(): Unit = {
    println("Job ID: " + Thread.currentThread().getId + " executing sms jobs")
    sms.sendSms
  }
}