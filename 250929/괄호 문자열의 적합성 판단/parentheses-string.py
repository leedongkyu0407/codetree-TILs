str = input()
list_str = list(str)
stack = []

for i in range(len(list_str)):
    if(list_str[i] == '('):
        stack.append(list_str[i])
    elif(list_str[i] == ')'):
        if(stack[-1] != '('):
            continue
        else:
            stack.pop()


if(len(stack)!=0):
    print("No")
else:
    print("Yes")

# Please write your code here.
