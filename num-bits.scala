//find number of bits set to 1 in any integer
def numBits(i: Int): Int = {
  var cur = i
  var counter = 0
  while (cur != 0) {
    if((cur & 1) == 1)  {
      counter += 1
    }
    cur = cur >>> 1
  }
  counter
}