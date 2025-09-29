str = input()
stack = []
flag = True
for i in range(len(str)):
    if(str[i] == '('):
        stack.append(str[i])
    elif(str[i] == ')'):
        if(stack[-1] == '('):
            stack.pop()
        else:
            flag = False
            print("No")
            break

if(flag):
    if(len(stack)==0):
        print("Yes")
    else:
        print("No")
