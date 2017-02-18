class Counter(num: Int){

  def count(): Int = { num }

  def inc(): Counter = { new Counter(count + 1) }

  def dec(): Counter = { new Counter(count - 1) }

}

