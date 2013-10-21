//http://projecteuler.net/problem=2
import scala.collection.mutable.HashMap
val fibsMap = HashMap[Int, Int]()
fibsMap += (0 -> 0)
fibsMap += (1 -> 1)
def evenFibs(n: Int = 0, soFar: Int = 0, limit: Int = 4000000): Int = {
    if(soFar >= limit) {
        soFar
    } else {
        val thisFib = if(n == 0 || n == 1) {
            fibsMap(n)
        } else {
            val value = fibsMap(n - 1) + fibsMap(n - 2)
            fibsMap += (n -> value)
            value
        }
        val newSoFar = if(thisFib % 2 == 0) {
            soFar + thisFib
        } else {
            soFar
        }
        evenFibs(n + 1, newSoFar, limit)
    }
}
