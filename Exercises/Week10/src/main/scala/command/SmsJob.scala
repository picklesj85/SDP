package command

class SmsJob extends Job {

  private var sms: Sms = _

  def setSms(sms: Sms) = this.sms = sms

  override def run: Unit = sms.sendSms()
}
