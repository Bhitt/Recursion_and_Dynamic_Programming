/*
	Fibonacci Numbers

	Finding a fibonacci number is a great example of dynamic programming. Each number is the sum of
	the previous two numbers, starting from 0 and 1.
*/

/* 
	A simple recursive solution

	The runtime of this solution is roughly O(2^n). Drawing the recursive calls as a tree illustrates
	this. The root node has two children. Each of those children has two children (so 4 children total
	at the grandchild level). Each of those grandchildren has two children, and so on. If we do this
	n times, we'll have roughly O(2^n) nodes.
*/

int fibonacci(int i){
	if(i == 0) return 0;
	if(i == 1) return 1;
	return fibonacci(i-1) + fibonacci(i-2);
}

/*
	Top-Down Dynamic Programming (or Memoization)

	There are lots of identical nodes in the tree described above. Why should we recompute these from
	scratch every time? In fact, when we call fib(n), we shouldn't have to do much more than O(n)
	calls, sincee there's only O(n) possible values we can throw at fib. Each time we compute fib(i),
	we should just cache this result and use it later.

	This is what memoization is.
*/

int fibonacci(int n){
	return fibonacci(n, new int[n+1]);
}

int fibonacci(int i, int[] memo){
	if(i == 0 || i == 1) return i;

	if(memo[i] == 0){
		memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
	}
	return memo[i];
}

/*
	Bottom-Up Dynamic Programming

	Think about doing the same things as the recursive memoized approach, but in reverse. First, we
	compute fib(1) and fib(0), which are already known for the base cases. Then we use those to
	compute fib(2). Then we use the prior answers to compute fib(3), then fib(4), and so on.
*/

int fibonacci(int n){
	if(n == 0) return 0;
	else if(n == 1) return 1;

	int[] memo = new int[n];
	memo[0] = 0;
	memo[1] = 1;
	for(int i = 2; i < n; i++){
		memo[i] = memo[i - 1] + memo[i - 2];
	}
	return memo[n - 1] + memo[n - 2];
}

/*
	If you think about how this works, you only use memo[i] for memo[i+1] and memo[i+2]. You don't
	need it after that. Therefore, we can get rid of the memo table and just store a few variables.
*/

int fibonacci(int n){
	if(n == 0) return 0;
	int a = 0;
	int b = 1;
	for(int i = 2; i < n; i++){
		int c = a + b;
		a = b;
		b = c;
	}
	return a + b;
}