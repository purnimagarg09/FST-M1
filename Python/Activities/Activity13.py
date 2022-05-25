#function definition to calculate sum
def sum(list):
    sum=0
    for i in range(len(list)):
        sum+=list[i]
    return sum

count=int(input("Enter number of elements in list : "))
list=[]

for x in range(count):
    number = int(input("Enter List element: "))
    list.append(number)

print("List elements : ",list)
#function call to calculate sum
print("Sum of all elements in list : ", sum(list))