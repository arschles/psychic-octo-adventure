import scala.collection.mutable.{Set => MutableSet, MutableList}
//http://projecteuler.net/problem=3
//a prime factor of N is a prime number for which N % thePrime = 0
//run the Sieve of Eratosthenes algorithm to get all primes less than a number.
//then start from the largest prime (last element in the array) and stop when we find a factor of the number

def sieve(number: Int): List[Int] = {
  val allNumbers = 2.until(number + 1).toList
  val eliminatedIdx = MutableSet[Int]()
  var p = 2
  while(p <= number) {
    //cross out every increment of p after current p
    var curP = p + p
    var numElim = 0
    while(curP <= number) {
      if(!eliminatedIdx.contains(curP)) {
        eliminatedIdx += curP
        numElim += 1
      }
      curP += p
    }
    
    if(numElim == 0) {
      //if we didn't eliminate any more numbers, this is the end of the loop
      p = number + 1
    } else {
      //otherwise, find next number in the list after current p
      p += 1
      var found = false
      while(!found && p <= number) {
        if(!eliminatedIdx.contains(p)) {
          found = true
        } else {
          p += 1
        }
      }
    }
  }
  
  //filter out all numbers that are in the eliminatedIdx set
  allNumbers.filter { number =>
    !eliminatedIdx.contains(number)
  }
}

def largestPrimeFactor(number: Int): Int = {
  val primes = sieve(number)
  var idx = primes.length - 1
  var largest = 2
  var found = false
  while(idx >= 0 && !found) {
    val prime = primes.apply(idx)
    if(number % prime == 0) {
      largest = prime
      found = true
    }
    idx -= 1
  }
  largest
}
