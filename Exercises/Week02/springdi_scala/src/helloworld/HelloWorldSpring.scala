package helloworld

import java.io.FileInputStream
import java.util.Properties

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.support.{DefaultListableBeanFactory, PropertiesBeanDefinitionReader}

object HelloWorldSpring extends App {
  @throws(classOf[Exception])
  val factory: BeanFactory = getBeanFactory
  val mr: MessageRenderer = factory.getBean("renderer").asInstanceOf[MessageRenderer]
  val mp: MessageProvider = factory.getBean("provider").asInstanceOf[MessageProvider]
  mr.setMessageProvider(mp)
  mr.render

  @throws(classOf[Exception])
  private def getBeanFactory: BeanFactory = {
    val factory: DefaultListableBeanFactory = new DefaultListableBeanFactory
    val rdr: PropertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(factory)
    val props: Properties = new Properties
    props.load(new FileInputStream("Week02/springdi_scala/src/helloworld/beans.properties"))
    rdr.registerBeanDefinitions(props)
    return factory
  }
}