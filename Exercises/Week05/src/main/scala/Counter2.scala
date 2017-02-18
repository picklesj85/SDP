
case class Counter2(num: Int = 0) {

  def count(): Int = { num }

  def inc(): Counter2 = { this.copy(count + 1) }

  def dec(): Counter2 = { this.copy(count - 1) }

  def inc(num: Int): Counter2 = { this.copy(count + num) }

  def dec(num: Int): Counter2 = { this.copy(count - num) }
}
