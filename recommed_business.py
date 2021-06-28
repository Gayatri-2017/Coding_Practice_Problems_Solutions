class Business:
    def __init__(self,name,nearbyBusinesses):
        self.name = name
        self.nearbyBusinesses = nearbyBusinesses

business_d = Business('D',dict())
business_b = Business('B',dict([(business_d,5)]))
business_c =  Business('C',dict())
business_a = Business('A',dict([(business_b,2),(business_c,4)]))

res = []
visited = set()
def findReachableBusiness(business, target):
    dfs(business,target, 0)

def dfs(business,target,dist):
    visited.add(business.name)
    if(dist <= target):
        res.append(business.name)
    for n,dist_val in business.nearbyBusinesses.items():
        if n.name not in visited:
            visited.add(n.name)
            dfs(n,target,dist+dist_val)


start_node = business_a.name
findReachableBusiness(business_a,7)
print(res)
print(res.remove(start_node))
# print([i for i in res if i!=start_node])
print(res)

