package bc

import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import vm.VirtualMachine

class ByteCodeTests extends FunSuite with ByteCodeValues {

  test("iconst code") {
    val iconst = new Iconst(5)
    assert(iconst.code == bytecode("iconst"))
  }

  test("iadd code") {
    val iadd = new Iadd
    assert(iadd.code == bytecode("iadd"))
  }

  test("isub code") {
    val isub = new Isub
    assert(isub.code == bytecode("isub"))
  }

  test("imul code") {
    val imul = new Imul
    assert(imul.code == bytecode("imul"))
  }

  test("idiv code") {
    val idiv = new Idiv
    assert(idiv.code == bytecode("idiv"))
  }

  test("irem code") {
    val irem = new Irem
    assert(irem.code == bytecode("irem"))
  }
}
