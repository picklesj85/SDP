package bc

import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import vm.VirtualMachine

class ByteCodeTests extends FunSuite with ByteCodeValues {

  test("iconst code") {
    val iconst = new Iconst(5)
    assert(iconst.code == bytecode("iconst"))
  }


}
