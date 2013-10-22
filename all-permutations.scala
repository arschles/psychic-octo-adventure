import scala.collection.mutable.MutableList

//get all permutations of a given list

implicit class RichList[T](list: List[T]) {
  def swap(firstIdx: Int, secondIdx: Int): List[T] = {
    val mutable = MutableList(list: _*)
    val first = mutable(firstIdx)
    val second = mutable(secondIdx)
    mutable(firstIdx) = second
    mutable(secondIdx) = first
    mutable.toList
  }
}

def allPerms[T](coll: List[T]): List[List[T]] = {
  var idx = 0
  val lists = MutableList.empty[List[T]]
  while(idx < coll.length) {
    var secondIdx = idx + 1
    while(secondIdx < coll.length) {
      lists ++= List(coll.swap(idx, secondIdx))
      secondIdx += 1
    }
    idx += 1
  }
  lists.toList
}