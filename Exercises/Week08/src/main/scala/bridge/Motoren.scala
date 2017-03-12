package bridge


case class Motoren(product: Product, s: String) extends Car(product, s) {
  override def assemble: Unit = {
    println("Assembling " + product.productName + " for " + s)
  }

  override def produceProduct: Unit = {
    product.produce
    println("Modifying product " + product.productName + " according to " + s)
  }

  override def printDetails: Unit = {
    println(s"Car: $s, Product: " + product.productName)
  }
}
