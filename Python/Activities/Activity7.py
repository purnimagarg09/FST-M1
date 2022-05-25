count=int(input("Enter number of elements in list : "))
list=[]
for x in range(count):
    number = int(input("Enter List element: "))
    list.append(number)

print("List elements :")
print(list)

sum=0
for i in range(len(list)):
    sum+=list[i]

print("Sum of all elements in list : "+str(sum))