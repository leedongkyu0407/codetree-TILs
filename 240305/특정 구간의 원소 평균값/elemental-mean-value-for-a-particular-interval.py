n = int(input())
n_list = list(map(int, input().split()))

#[1, 1], [2, 2]...[n, n]과 같이 구간 안에 원소가 하나일 경우 조건 만족
ans = n
#시작점
for i in range(n):
    #구간 길이
    for j in range(n-i):
        s = 0
        avg = 0
        for k in range(i, i+j):
            s += n_list[k]
        avg = s/(j+1)
        if avg in n_list[i:i+j]:
            ans += 1
        

print(ans)