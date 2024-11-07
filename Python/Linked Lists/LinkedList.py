class Node():
    def __init__(self,data,next=None):
        self.data=data
        self.next=next

class LinkedList():
    def __init__(self):
        self.head=None
    def insert_begin(self,data):
        if self.head is None:
            self.head=Node(data,None)
        else:
            self.head=Node(data,self.head)
    def insert_end(self,data):
        if self.head is None:
            self.head=Node(data,None)
        else:
            currNode=self.head
            while currNode.next is not None:
                currNode=currNode.next
            currNode.next=Node(data,None)
    def display(self):
        if self.head is None:
            print('No Elements are present')
            return
        itr=self.head
        while itr.next:
            print(str(itr.data)+"->",end="")
            itr=itr.next
        print(itr.data)
    def search(self,data):
        if self.head is None:
            print('No Elements are present')
            return
        itr=self.head
        index=0
        while itr:
            if (itr.data==data):
                print("Element found at",index)
                return
            itr=itr.next
            index+=1
        else:
            print("Element not found")
    def __len__(self):
        itr=self.head
        count=0
        while itr:
            itr=itr.next
            count+=1
        return count
        
    def insert(self,data,index):
        if index==0:
            self.insert_begin(data)
        elif index==len(self):
            self.insert_end(data)
        else:
            if index>len(self) or index<0:
                print("Invalid Index")
                return
            else:
                itr=self.head
                counter=0
                while itr:
                        if (counter<index-1):
                            itr=itr.next
                            counter=counter+1
                        else:
                            break
                    
                    
                       
                itr.next=Node(data,itr.next)
    def deleteLast(self):
        if self.head is None:
            print('No Elements are present')
            return
        elif (len(self)==1):
            self.head=None
        else:
            currElement=self.head
            
            while(currElement.next.next):
                currElement=currElement.next
            currElement.next=None
    def deleteFirst(self):
        if self.head is None:
            print('No Elements are present')
            return
        elif (len(self)==1):
            self.head=None
        else:
            self.head=self.head.next
    def delete(self,index):
        if index==0:
            self.deleteFirst()
        elif index==len(self)-1:
            self.deleteLast()
        else:
            if index>len(self)-1 or index<0:
                print("Invalid Index")
                return
            else:
                itr=self.head
                counter=0
                while itr:
                    if(counter<index-1):
                        itr=itr.next
                        counter+=1
                    else:
                        break
                itr.next=itr.next.next

            


        
        





ll=LinkedList()
ll.insert_begin(1)
ll.insert_end(45)
ll.insert_begin(13)
ll.insert(45,1)
ll.search(45)
ll.insert(85,2)
ll.insert(90,len(ll))
ll.delete(6)

print(ll.display())
