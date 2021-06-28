class TimeRange:
    def __init__(self,start,end):
        self.start  = start
        self.end = end

queryTimeRange = TimeRange(7,11)
openHours = []

def openHoursRatio(queryTimeRange, openHours):

    personStartTime = queryTimeRange.start
    personEndTime = queryTimeRange.end
    overlap = 0.0
    for i in openHours:
        if(personEndTime > i.start and personStartTime < i.end):
            overlap_start = max(personStartTime,i.start)
            overlap_end = min(personEndTime,i.end)
            if((overlap_end - overlap_start) > 0):
                overlap+=(overlap_end-overlap_start)
    if(personStartTime!=personEndTime):
        print(overlap/(personEndTime - personStartTime))

openHoursRatio(queryTimeRange, openHours)
