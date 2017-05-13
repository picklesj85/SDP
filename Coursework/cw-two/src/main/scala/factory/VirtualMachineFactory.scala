package factory

import bc.{ByteCodeFactory, ByteCodeFactoryImpl, ByteCodeParser, ByteCodeParserImpl}
import vendor.{ProgramParser, ProgramParserImpl}
import vm.{VirtualMachine, VirtualMachineImpl, VirtualMachineParser, VirtualMachineParserImpl}

/** A singleton specifying the dependencies between ProgramParser, ByteCodeParser
  * and VirtualMachineParser implementations for VirtualMachines
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = ByteCodeFactoryImpl


  def vendorParser: ProgramParser = new ProgramParserImpl()


  def byteCodeParser: ByteCodeParser = new ByteCodeParserImpl(ByteCodeFactoryImpl)


  def virtualMachineParser: VirtualMachineParser = new VirtualMachineParserImpl(new ProgramParserImpl(), new ByteCodeParserImpl(ByteCodeFactoryImpl))


  def virtualMachine: VirtualMachine = new VirtualMachineImpl(Vector())
}
