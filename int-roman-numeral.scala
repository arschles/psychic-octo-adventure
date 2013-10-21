//turn integers into roman numerals, and turn roman numerals into integers
//roman numerals are read left to right, starting with the biggest number on the left.
//exceptions:
//- the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
//- X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
//- C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern[5]

val numeralList = List(
  1 -> "I",
  4 -> "IV",
  5 -> "V",
  9 -> "IX",
  10 -> "X",
  40 -> "XL",
  50 -> "L",
  90 -> "XC",
  100 -> "C",
  400 -> "CD",
  500 -> "D",
  900 -> "CM",
  1000 -> "M"
)

val numeralMap = numeralList.map { tup =>
  tup._2 -> tup._1
}.toMap

def intToRomanNumeral(i: Int, cur: String = ""): String = {
  //base case
  if(i <= 0) {
    cur
  } else {
    //find the largest numeral that is less than i
    var idxLargestLessThan = 0
    var idx = 0
    while (idx < numeralList.length) {
      val (thisInt, numeral) = numeralList.apply(idx)
      if(thisInt <= i) {
        idxLargestLessThan = idx
      }
      idx = idx + 1
    }

    val (int, numeral) = numeralList.apply(idxLargestLessThan)
    intToRomanNumeral(i - int, s"$cur$numeral")
  }
}

def romanNumeralToInt(numeral: String): Int = {
  if(numeral.length == 0) {
    0
  } else {
    var cur = 0
    var idx = 0
    while (idx < numeral.length) {
      //check for subtractive reductions. this works because a lower numeral comes before a larger in subtractive reductions
      try {
        val value = numeralMap.get(numeral.substring(idx, idx + 2)).get
        idx += 2
        cur += value
      } catch {
        case t: Throwable => {
          val value = numeralMap.get(numeral.substring(idx, idx + 1)).get
          idx += 1
          cur += value
        }
      }
    }
    cur
  }
}