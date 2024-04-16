n, B = map(int, input().split())
price = []
for _ in range(n):
    p = int(input())
    price.append(p)

price.sort()
ans = 0

for i in range(n):
    #반값 선물
    pi = price[i]//2
    people = 0
    b = B
    for j in range(n):
        if i == j:
            p = pi
        else:
            p = price[j]
        
        
        if b - p >= 0:
            b -= p
            people += 1
    print(people)
    ans = max(people, ans)

print(ans)