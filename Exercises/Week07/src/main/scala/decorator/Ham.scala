package decorator

class Ham(val newPizza: Pizza) extends PizzaDecorator(newPizza) {

  override def getDesc: String = {
    newPizza.getDesc + ", Ham (18.12)"
  }

  override def getPrice: Double = {
    newPizza.getPrice + 18.12
  }
}
