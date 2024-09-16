import sys
from collections import deque
x, y = input().split()

stack = deque()
num1 = int(x)
num2 = int(y)

ans = 0
for n in range(num1, num2):
    n_str = str(n)
    mid = len(n_str)//2
    front = n_str[:mid]
    if(len(n_str)%2==1):
        back = n_str[mid+1:]
    else:
        back = n_str[mid:]

    if(front == back[::-1]):
        ans += 1
    
print(ans)