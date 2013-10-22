//write a function that takes in str, a base-3 number as a string, and return a string that is num + 1. do not convert to an int

implicit class RichString(s: String) {
  def replaceIdx(idx: Int, char: Char): String = {
    val before = s.substring(0, idx)
    val after = s.substring(idx + 1, s.length)
    s"$before$char$after"
  }
}

def base3PlusOne(str: String, idxOffset: Int = 1): String = {
  val idx = str.length - idxOffset
  if(idx == -1) {
    s"1$str"
  } else {
    val digit = str.apply(idx)
    digit match {
      case '0' => str.replaceIdx(idx, '1')
      case '1' => str.replaceIdx(idx, '2')
      case '2' => str.replaceIdx(idx, '3')
      case '3' => {
        val newStr = str.replaceIdx(idx, '0')
        base3PlusOne(newStr, idxOffset + 1)
      }
    }
  }
}
