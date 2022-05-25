count1=int(input("Enter number of elements in list1 : "))
list1=[]
for x in range(count1):
    number = int(input("Enter List element: "))
    list1.append(number)

count2=int(input("Enter number of elements in list2 : "))
list2=[]
for x in range(count2):
    number = int(input("Enter List element: "))
    list2.append(number)

print("List1 elements :",list1)
print("List2 elements :",list2)

list3=[]
for i in range(count1):
    if list1[i]%2 != 0:
        list3.append(list1[i])

for i in range(count2):
    if list2[i]%2 == 0:
        list3.append(list2[i])

print("List3 elements :",list3)