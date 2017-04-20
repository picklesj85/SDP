package prototype

class Admin(var userName: String,
            var level: String,
            var accessControl: AccessControl) {

  override def toString() = s"Name: $userName, Level: $level, Access Control Level: " + accessControl.controlLevel +
    ", Access: " + accessControl.access
}
