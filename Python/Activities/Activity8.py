count=int(input("Enter number of elements in list : "))
list=[]
for x in range(count):
    number = int(input("Enter List element: "))
    list.append(number)

print("List elements :",list)
print("Validating First and last elements in list")

if list[0]==list[-1]:
    print("True")
else:
    print("False")