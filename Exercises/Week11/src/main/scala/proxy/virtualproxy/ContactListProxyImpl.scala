package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

class ContactListProxyImpl extends ContactList {

  private var contactList: ContactList = _

  override def employeeList: ListBuffer[Employee] = {
    println("Creating contact list and fetching list of employees...")
    if (contactList == null) contactList = new ContactListImpl // using null as didn't want to change provided code
    contactList.employeeList
  }
}
