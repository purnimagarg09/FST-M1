def fibonacci(num):
    if num <= 1:
        return num
    else:
        return fibonacci(num-1)+fibonacci(num-2)

num = int(input("Enter the count of fibonacci numbers to be printed: "))
print("Fibonacci sequence of ",num,"numbers : ")
for x in range(num):
    print(fibonacci(x),end=" ")