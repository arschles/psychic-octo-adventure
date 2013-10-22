//count the number of ways to traverse a grid from one corner to the other w/o backtracking
//this is the same as a graph traversal. we'll use depth first search

def traverse(grid: Array[Array[Int]],
             cur: (Int, Int),
             target: (Int, Int),
             next: Set[(Int, Int)] = Set.empty[(Int, Int)],
             seen: Set[(Int, Int)] = Set.empty[(Int, Int)]): Set[List[Int]] = {
  
}
