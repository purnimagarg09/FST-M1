import pandas as pd

dataframe = pd.read_excel('resources\ activity19.xlsx')
print(dataframe)

print("Number of rows in excel sheet : ", len(dataframe))
print("Number of columns in excel sheet : ", len(dataframe.columns))
print()

print("Data in the emails column : ")
print(dataframe["Email"])
print()

print("Data sorted based on FirstName in ascending order :")
print(dataframe.sort_values("FirstName"))