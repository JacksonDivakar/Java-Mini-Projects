#Largest continuous sequence in an array
arr=[1,2,-2,4,-4]
max_length=0
returnArray=[]
for i in range(len(arr)):
    currSum=arr[i]
    currArray=[arr[i]]
    for j in range(i+1,len(arr)):
        currSum+=arr[j]
        currArray.append(arr[j])
        if currSum==0:
            if (max_length<len(currArray)):
                max_length=len(currArray)
                returnArray=currArray
            

print(returnArray)