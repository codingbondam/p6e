# p6e

## general tips
1. simple problems you can use standard patterns and arrive at a solution and finish coding. remember to do a detailed dry run when you are messing with indices. bar could be high, aim for bug free code.
2. complex problems can lead to frustration and overwhelming feeling. break them down, take note of parts of the solution as you solve. form a high level pseudo code first and arrange them as necessary by going back to drawing board until you are confident to code. and code in pieces as you might run out of time. think what the interview might want to see in the next 45 mins. focus less on upfront optimizations and rely on library methods or extra memory in first run. point out that with more time you can work out more optimizations in the sub parts.
3. hard problems. there will be a problem you can't solve. understand if you are increasing the scope. try to iterate it down into a simple or complex problem. try different ideas quickly to show progress. 
4. keep your discipline in thought, move slowly. don't give up as the bar for this problem might not be the end solution but how we iterate or attempt to solve it. don't get tired, stay passionate and practical just like how you solve a problem at work, avoid binary fallout and stay mindful of the code you write or words you speak, remember its not the end of the world. think what can you accomplish in next 45 mins. 

5. think and code each line and try to write pseudo code for such problems first
6. make sure solution is simple and easy to follow without doing a lot of back and forth
7. when problem gets tougher or you are stuck in an approach, try going to drawing board and focussing on getting it to work first than optimizations or elegance.

1. problem description, clarifications, examples, etc
2. trying ideas, testing with different examples, observing patterns, considering alternatives, time/space complexities, designing the algorithm, etc
3. designing code, pseudo code, leveraging extra memory or library methods as needed
4. writing code
5. dry run
6. test cases


## general patterns and tips
4. you can use an array in place of a hash map some times to keep the code simple
5. when you have two much state to maintain, a recursive function is an option if the algorithm is recursive
6. recursive algorithms might not be efficient always but could simplify the code. they are sometimes hard to build
7. when the problem is too complex, focus on less on upfront optimizations and rely on library methods or extra buffers 
 
## linked lists

### general patterns and tips
1. use two pointers
2. increment two pointers at different speed
3. increment one of the pointers early

## sort

### algorithms
1. insertion sort - insert the new element into a sorted set of elements
2. selection sort - select the least in the unordered list and swap it with the first position in it
3. quick sort - select a pivot, divide such that elements left to pivot are smaller and elements right to pivot are bigger than pivot and sort left list and right list
4. merge sort - divide into two lists, sort each list, and merge the sorted lists

### complexities
1. insertion sort - O(N^2)
2. selection sort - O(N) to O(N^2)
2. quick sort - O(Nlog(N)) to O(N^2)
3. merge sort - O(Nlog(N))

### known for
1. insertion sort - in place, stable, less overhead so preferred for smaller N, works better with presorted lists
2. selection sort - in place, not stable, only O(N) swaps so preferred when copying is costly
3. quick sort - in place, not stable,
4. merge sort - needs additional memory of O(N), suitable for cases where upper bound must be O(Nlog(N)) and data is too large
5. hybrid - hybrid approaches are used for general purpose sort algorithms found in librarires

### things to consider while chosing a sort algorithm
1. additional memory
2. size of N
3. stability
4. mostly sorted or random?

### caveats
1. insertion sort looks like O(N^3) but note that in the second O(N) you either search through to find the position for K positions and for remaining N - K you shift them. So its only O(N)

## strings

### things to remember

1. `utf-8` uses 1 to 4 8-bit chars to encode Unicode code points
2. `utf-16` ues 1 to 2 16-bit chars
3. frequent unicode code points are encoded with lesser number of chars
4. `ascii` encoded text becomes subset of `utf-8` encoded text
5.  In java char is 2 byte. String is internally stored as an array of `char`
6. `StringBuffer` is threadsafe while `StringBuilder` is more efficient
7. The compiler uses `StringBuffer` when you concatenate using `+`

### general patterns and tips
1. use a hash map or an array for lookups
2. in memory string reversal using two pointers



