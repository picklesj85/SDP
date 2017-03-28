package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImpl, ByteCodeParser, ByteCodeParserImpl}
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = ByteCodeFactoryImpl


  def vendorParser: ProgramParser = new ProgramParserImpl()


  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl(ByteCodeFactoryImpl)

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}
