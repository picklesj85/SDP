class Counter(num: Int){

  def count(): Int = { num }

  def inc(): Counter = { new Counter(count + 1) }

  def dec(): Counter = { new Counter(count - 1) }

  def inc(num: Int): Counter = { new Counter(count + num) }

  def dec(num: Int): Counter = { new Counter(count - num) }

}

