from collections import defaultdict

class Business:
  def __init__(self,name,location,bid):
    self.name = name
    self.location = location
    self.bid = bid

class Chain:
  def __init__(self,name,freq):
    self.name = name
    self.freq = freq

def getChain(businessList,targetLocation):
  print('targetLocation - {}'.format(targetLocation))
  chainData = {}
  for item in businessList:
    name,location,bid = item.name,item.location,item.bid
    if location == targetLocation:
      if name+'-'+str(bid) in chainData.keys():
        chainData[name+'-'+str(bid)].freq+=1
      else:
        chainData[name+'-'+str(bid)]=Chain(name,1)
  print(chainData.keys())
  return [(v.name,v.freq) for v in sorted(chainData.values(),key = lambda x: (x.freq,x.name))]


if __name__=='__main__':
  businessList = list()
  for _ in range(5):
    businessList.append(Business('coke','india',1))
  for _ in range(3):
    businessList.append(Business('coke','italy',1))
  for _ in range(4):
    businessList.append(Business('pepsi','india',2))
  for _ in range(3):
    businessList.append(Business('pepsi','india',6))
  for _ in range(5):
    businessList.append(Business('dabur','india',3))
  for _ in range(5):
    businessList.append(Business('raw','india',4))
  for _ in range(4):
    businessList.append(Business('pepsi','argentina',2))
  print(getChain(businessList,'india'))
  # print(getChain(businessList,'italy'))
  # print(getChain(businessList,'argentina'))
