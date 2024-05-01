#학생 수(n) / 예산(b)
n, b = map(int, input().split())

prices_ship = []
for _ in range(n):
    p, s = map(int, input().split())
    prices_ship.append((p, s))

#예산 초과 확인 함수
def is_over(p, b):
    return p > b

#선물 가능한 최대 학생 수
max_n = 0
for i in range(n):
    #쿠폰 사용할 선물
    half = prices_ship[i][0]//2 + prices_ship[i][1]
    #가격+배송비들의 합
    price_sum = 0
    #학생 수
    temp_n = 0
    for j in range(n):
        if i == j:
            price = half
        
        else:
            price = (prices_ship[j][0] + prices_ship[j][1])
        
        if is_over(price_sum+price, b) == False:
            price_sum += price
        
            temp_n += 1
        
    max_n = max(max_n, temp_n)

print(max_n)