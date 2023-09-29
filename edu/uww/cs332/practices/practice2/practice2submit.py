"""give important info from country_info.csv"""
import pandas as pd

df = pd.read_csv("edu/uww/cs332/practices/country_info.csv")

print(df,"\n")
print(df.shape)
print(df.size,"\n")

country_list = df['country'].tolist()
set_res = set(country_list)
print("The unique elements of the input list using set():")
country_list = (list(set_res))

for i in country_list:
    print(i)

print(df['salary'].mean())

print(df['salary'].sum())

print(df['salary'].max())

print(df['salary'].min())

print(df['salary'].count())

print(df['salary'].median())

print(df['salary'].std())

print(df['salary'].var())
