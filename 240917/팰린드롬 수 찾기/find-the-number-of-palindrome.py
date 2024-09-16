import sys
from collections import deque
x, y = input().split()

num1 = int(x)
num2 = int(y)

ans = 0
for n in range(num1, num2):
    n_str = str(n)
    n_reversed = n_str[::-1]
    if(n_str == n_reversed):
        ans += 1

print(ans)