from collections import defaultdict
class Event:
    def __init__(self,etype,occ,buid):
        self.etype=etype
        self.occ = occ
        self.buid = buid

def getActiveBusiness(eventList):
    dictionary = defaultdict(list)
    buisnessValues = defaultdict(dict)
    averages = defaultdict(float)
    for i in eventList:
        dictionary[i.etype].append(i.occ)
        buisnessValues[i.buid][i.etype]=i.occ
    print(buisnessValues)
    for eventtpye,sum_of_occ in dictionary.items():
        averages[eventtpye] = sum(sum_of_occ)/len(sum_of_occ)

    res = []
    for buid,event_occ in buisnessValues.items():
        k = 0
        if(len(event_occ.keys()) < 2):
            continue
        for key,value in event_occ.items():
            if(value >= averages[key]):
                k+=1
        if(k >= 2):
            res.append(buid)
    return (sorted(res))
















if __name__=='__main__':
  eventList = list()
  eventList.append(Event('ads',7,3))
  eventList.append(Event('ads',8,2))
  eventList.append(Event('ads',5,1))
  eventList.append(Event('page_views',11,2))
  eventList.append(Event('page_views',12,3))
  eventList.append(Event('photo_views',10,3))
  eventList.append(Event('reviews',7,2))
  print(getActiveBusiness(eventList))




