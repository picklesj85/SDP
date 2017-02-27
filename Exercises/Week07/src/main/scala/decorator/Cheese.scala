package decorator

class Cheese(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    newPizza.getDesc + ", Cheese (0.72)"
  }

  override def getPrice: Double = {
    newPizza.getPrice + 20.72
  }
}
