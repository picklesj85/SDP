package decorator

class Spinach(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    newPizza.getDesc + ", Spinach (7.92)"
  }

  override def getPrice: Double = {
    newPizza.getPrice + 7.92
  }
}
