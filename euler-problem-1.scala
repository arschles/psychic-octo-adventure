//http://projecteuler.net/problem=1
def sumMultiples(limit: Int, last: Int = 0, soFar: Int = 0): Int = {
    val cur = last + 1
    if(last >= limit) {
        soFar
    } else {
        val newSoFar = if(cur % 3 == 0 || cur % 5 == 0) {
            soFar + cur
        } else {
            soFar
        }
        sumMultiples(limit, cur, newSoFar)
    }
}