#빙산의 개수
n = int(input())
heights = []
for _ in range(n):
    h = int(input())
    heights.append(h)

ans = 0
#해수면 높이 최댓값은 1000
for i in range(1, 1001):
    sea_level = i
    cnt = 0
    #앞선 빙산이 물위로 드러나 있는지
    is_over = True
    for j in range(n):  
        if is_over:
            #빙산 한 덩어리가 끝나는 지점
            if heights[j] <= sea_level:
                is_over = False
                cnt += 1
        else:
            #빙산 한 덩어리가 시작하는 지점
            if heights[j] > sea_level:
                is_over = True
            
    #n번째 빙산이 마지막 빙산 덩어리에 포함되어 있는 경우
    if is_over:
        cnt += 1
    
    ans = max(ans, cnt)

print(ans)