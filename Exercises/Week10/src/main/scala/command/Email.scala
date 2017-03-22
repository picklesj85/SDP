package command

case class Email() {
  def sendEmail() = println("Sending email.......")
}

case class Sms() {
  def sendSms() = println("Sending SMS...")
}

case class FileIO() {
  def executeFileIO() = println("Executing File IO operations...")
}

case class Logging() {
  def log() = println("Logging...")
}
