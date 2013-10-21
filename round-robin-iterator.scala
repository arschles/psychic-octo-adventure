import scala.annotation.tailrec
import java.lang.UnsupportedOperationException
import java.util.concurrent.CopyOnWriteArraySet
import java.util.concurrent.atomic.AtomicInteger

//an iterator that iterates over a List of iterators in round robin.
//all methods in this class are thread safe, and lockless
class RoundRobinIterator[T](iters: List[java.util.Iterator[T]]) extends java.util.Iterator[T] {
  private val excludes = new CopyOnWriteArraySet[Int]()

  private val counter = new AtomicInteger(0)  
  private val len = iters.length
  
  @tailrec
  private def getIdx: Option[Int] = {
    if(excludes.size() >= len) {
      None
    } else {
      val idx = counter.getAndIncrement() % len
      if(excludes.contains(idx)) {
        getIdx
      } else {
        Some(idx)
      }
    }
  }
  
  override def hasNext: Boolean = {
    getIdx.map { idx =>
      iters.apply(idx).hasNext
    }.getOrElse(false)
  }
  
  override def next: T = {
    getIdx.map { idx =>
      try {
        iters.apply(idx).next
      } catch {
        case t: NoSuchElementException => next
      }
    }.getOrElse {
      throw new NoSuchElementException("no more iterators have data")
    }
  }
  
  override def remove {
    throw new UnsupportedOperationException("remove is unsupported")
  }
}