import sys

def solution():
    S = sys.stdin.readline().strip()
    
    ans = 0
    idx = 0
    left = 0
    right = 0
    
    for i in range(len(S)):
        if S[i] == '(':
            idx += 1
            left += 1
        else:
            idx -= 1
            right += 1
        
        if idx <= 1:
            left = 0
        if idx == -1:
            ans = right
            break
            
    if idx > 0:
        ans = left
        
    print(ans)

solution()
