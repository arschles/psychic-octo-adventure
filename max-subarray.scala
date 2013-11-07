//return the sum of the maximum subarray in arr
def maxSubarray(arr: Array[Int]): Int = {
	//the maximum value of the subarray ending at an index
	var endingHere = 0
	//the maximum value of a subarray we've seen so far
	var allTime = 0

	var i = 0
	while(i < arr.size) {
		val elt = arr(i)
		endingHere = math.max(0, endingHere + elt)
		allTime = math.max(allTime, endingHere)
		i += 1
	}
	allTime
}