# Best time to buy / sell stocks
max_profit=0
arr=[4,2,890,156]
buy=arr[0]


for i in range(1,len(arr)):
    if arr[i]<buy:
        buy=arr[i]
        
    if(arr[i]-buy>max_profit):
        max_profit=arr[i]-buy
  
print(max_profit)