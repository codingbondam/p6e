# Goals
1. Beautifully written, bug free code
2. Optimal solution

# Practising
1. Make a list of most freq touched concepts
2. Start by familiarizing all concepts
3. Practise least comfortable problems first
4. Rotate and repeat
5. Keep it absolutely simple, no five setters and test matches on a single topic!

# Its okay to be a little methodic but make trade-offs for progress
## Coding problems
### Step 0
1. Understanding the problem
2. Clarifying with examples
### Step 1
1. Brute-forcing and optimizing using additional data structures or std algorithms
2. Trying it yourself with examples, drawing out patterns or using details
3. Base case and build
4. For complex problems, solve individual pieces separately and make note
### Step 2
1. Form a good understanding of the algorithm on how it works
2. Write high level working of the algorithm in plain english
3. Identify variables
### Step 3
1. Write code slowly, thoughtfully, modularize where necessary
2. Pay utmost attention to logic, syntax and var names while writing out code
3. Handle edge cases and null checks promptly. For cases like bit wise, code with an example at hand
### Step 4
1. Verify conceptually at a high level
2. Check hotspots like arithmetic and unusual logic
### Step 5
1. Dry run using a small test case. If there are many parts, dry run them individually
2. Use more test cases based on the complexity as time permits

## Design problems
### Step 0
1. Scoping/ questions
2. Write down use cases

### Step 1
1. Block diagram key components
2. Walk through use cases

### Step 2
1. Discuss bottlenecks, key issues, failures, availability, reliability, scalability, security
2. Optimize based on read/write usage

## Step 3
1. Redesign and fix

# A bit of philosophy
1. Think what you want to do in next 45 minutes. Avoid overwhelming yourself by solving everything that comes to your mind.
2. Avoid binary fall out. Work with you got and build from there.
3. Think and write each line of code. Syntax, logic and variable names.

```
Oh! I got this wrong!
Oh! This is so hard!
Oh! I didn't prepare for this!
 ```

That's okay, that's normal. **Work with what you got and build from there**.
See how far you can go in next 45 min.
And let them decide.

```
Oh! I know this solution!
I will implement it!
```

Stop! Walk me through. **Code it out loud!**

```
Uh oh! I see an issue.
```
That's expected. Call it out and explain what you are going to do next to fix it.

```
This is not perfect. This is not optimal. I see a better way to do it.
```
Stop! Do not go back and forth and optimize or refactor unnecessarily.

1. **Trust** what you got
2. Be **humble** about the outcome
3. Handle life with care, **gently**

Its a right place, right time thing with a bit of luck! Not necessarily because successful people are control freaks!

What seem to be helping during preparation?
1. Practicing under time pressure
2. Fundamentals
3. Going breadth wise over depth wise

# Frequently seen code tricks and trade-offs
1. boolean array for tracking visited nodes or matrix positions
2. hash map to identify duplicates or lookups
3. heap for finding top k
4. for a small key range, arrays will work fine
5. recursive function can help keep the code simple when you have a lot of state to maintain
6. recursion could lead to inefficient implementation, use memoization if necessary
7. use library functions, extra memory liberally first particularly for complex or hard problems
8. use two pointers at different speed or with a different head start
9. two pointer based string reversal for saving memory

# Frequently coded errors

|Error Description | Count |
|--- | --- |
| Missed null check on input | 3
| Missed input validation | 1
| Redefined the same variable name i, j | 1
| Return statement missing | 1
| Return type on signature doesn't match the type of returned object | 1
| Hardcoded 0 or input.length in recursive methods | 1
| Not assigning returned values in recursive calls | 1
| Did not handle key exists case when updating a hash map | 1
