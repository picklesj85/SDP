package decorator

abstract class PizzaDecorator(var tempPizza: Pizza) extends Pizza {

  override def getDesc = tempPizza.getDesc

  override def getPrice = tempPizza.getPrice
}
