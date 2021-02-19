# Write a function that calculates the nth Fibonacci number in O(n) time or better without using any "for" or "while" loops.

# It computes the nth Fibonacci number in O(2n-1) ~ O(n) 

def fibonacci(n, fib_dict={0:0, 1:1}):
  # Maintaining the count number of recursive function calls to check efficiency
	fibonacci.fn_call_count += 1
	
	if n > 0 and n not in fib_dict:
		fib_dict[n] = fibonacci(n-1, fib_dict) + fibonacci(n-2, fib_dict)
	return fib_dict[n]


 # Initializing the count of recursive function calls to 0
fibonacci.fn_call_count = 0

n = 400
print("For n = " , n, " nth Fibonacci number = ", fibonacci(n))
print("Number of recursive function calls = ", fibonacci.fn_call_count)

