fruits ={
    "banana": 50,
    "apple": 120,
    "mango": 100,
    "grapes": 90,
    "orange": 75
}
print("Fruits set",fruits)

fruit_search = input("Enter fruit name to search for : ")

if fruit_search in fruits:
    print (fruit_search + " is available in fruit dictionary set")
else:
    print (fruit_search + " is not available in fruit dictionary set")