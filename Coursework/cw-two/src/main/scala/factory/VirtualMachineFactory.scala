package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImpl, ByteCodeParser, ByteCodeParserImpl}
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineImpl, VirtualMachineParser, VirtualMachineParserImpl}


object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = ByteCodeFactoryImpl


  def vendorParser: ProgramParser = new ProgramParserImpl()


  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl(ByteCodeFactoryImpl)


  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParserImpl()


  def virtualMachine: VirtualMachine = new VirtualMachineImpl(Vector())
}
