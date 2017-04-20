package iterator

import java.util.Iterator

class ShapeIterator(private var shapes: Array[Shape]) extends Iterator[Shape] {

  private var count = 0

  override def hasNext(): Boolean =  {
    count < shapes.length
  }

  override def next(): Shape = {
    val next = shapes(count)
    count += 1
    next
  }

  override def remove(): Unit =  {
    shapes = shapes.take(count - 1) ++ shapes.drop(count)
  }
}