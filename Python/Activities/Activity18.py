# Import pandas
import pandas

dataframe = pandas.read_csv("../resources/username.csv")

print("Complete file: ")
print(dataframe)

print()
print("Print the values in the Usernames column only")
print(dataframe["Usernames"])

print()
print("Print the username and password of the second row")
print("Username: ", dataframe["Usernames"][1], "Password: ", dataframe["Passwords"][1])

print()
print("Sort the Usernames column in ascending order")
print(dataframe.sort_values('Usernames'))

print()
print("Sort the Passwords column in descending order")
print(dataframe.sort_values('Passwords', ascending=False))