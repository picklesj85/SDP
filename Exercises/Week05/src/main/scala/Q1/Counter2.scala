package Q1

/**
  * Created by James Pickles on 19/02/2017.
  */
case class Counter2(num: Int = 0) {

  def count(): Int = { num }

  def inc(): Counter2 = { copy(count + 1) }

  def dec(): Counter2 = { copy(count - 1) }

  def inc(num: Int): Counter2 = { copy(count + num) }

  def dec(num: Int): Counter2 = { copy(count - num) }

  def adjust(adder: Adder): Counter2 = { copy(adder.add(count))}
}
