count=int(input("Enter number of elements in tuple : "))
tuple_list=[]
for x in range(count):
    number = int(input("Enter tuple element "+ str(x)+" "))
    tuple_list.insert(x,number)

print("Tuple List elements : ",tuple_list)

print("Tuple elements divisible by 5")
for i in range(len(tuple_list)):
    if tuple_list[i]%5 == 0:
        print(tuple_list[i],end=" ")

