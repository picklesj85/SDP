package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImpl, ByteCodeParser, ByteCodeParserImpl}
import vendor.ProgramParser
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = new ByteCodeFactoryImpl()

  // TODO
  def vendorParser: ProgramParser = ???


  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl(VirtualMachineFactory.byteCodeFactory)

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}
