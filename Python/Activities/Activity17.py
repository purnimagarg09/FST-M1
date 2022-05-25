import pandas as pd
#alias to pandas

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pd.DataFrame(data)
print(dataframe)

dataframe.to_csv("resources/username.csv",index=False)  #index = False won't write Index column to file