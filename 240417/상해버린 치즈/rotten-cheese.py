#사람 수 / 치즈 수 / 치즈를 먹은 기록의 수 / 아픈 기록의 수
n, m, d, s = map(int, input().split())

eatings = []
for _ in range(d):
    #몇번째 사람(p)이 몇 번째 치즈(m)를 언제 먹었는지(t)
    eat_p, eat_m, eat_t = map(int, input().split())
    eatings.append((eat_p, eat_m, eat_t))

sick = []
for _ in range(s):
    #몇 번째 사람(p)이 언제 확실히 아팠는지(t)
    sick_p, sick_t = map(int, input().split())
    sick.append((sick_p, sick_t))

#사람 기준 정렬 => 동순위일 경우 시간순 정렬
eatings.sort(key=lambda x:(x[0], x[2]))

#상한 치즈
rotten = set()
for i in range(m):
    #치즈에 대해 정리
    cheeze = i+1

    for j in range(d):
        eat_p, eat_m, eat_t = eatings[j]
        
        for k in range(s):
            sick_p, sick_t = sick[k]
            #아프기 이전에 먹은 치즈들은 상한 치즈일 가능성이 존재 
            if (eat_p == sick_p) and (eat_t < sick_t) and (eat_m == cheeze):
                                
                rotten.add(eat_m)

#약이 필요한 사람
medicine = set()
for l in range(d):
    eat_p, eat_m = eatings[l][0], eatings[l][1]
    #상한 치즈를 먹은 사람들 추출
    if eat_m in rotten:
        medicine.add(eat_p)


print(len(medicine))