
def sum(num):
    if num>0:
        return num + sum(num-1)
    else:
        return 0

res = sum(10)

print("Sum of numbers from 0 to 10 is : " , res)