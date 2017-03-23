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

  test("ineg code") {
    val ineg = new Ineg
    assert(ineg.code == bytecode("ineg"))
  }

  test("iinc code") {
    val iinc = new Iinc
    assert(iinc.code == bytecode("iinc"))
  }

  test("idec code") {
    val idec = new Idec
    assert(idec.code == bytecode("idec"))
  }

  test("iswap code") {
    val iswap = new Iswap
    assert(iswap.code == bytecode("iswap"))
  }

  test("idup code") {
    val idup = new Idup
    assert(idup.code == bytecode("idup"))
  }

  test("print code") {
    val print = new Print
    assert(print.code == bytecode("print"))
  }
}
