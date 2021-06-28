
def topicoccurence(top,rev):
    rev = rev.split(" ")
    dic = {}
    count = 0
    for k,v in top.items():
        if k == "Price" or k == "Business" or k == "Harry":
            for i in range(len(v)):
                for j in range(len(rev)):
                    if v[i] == rev[j]:
                        count+=1
            dic[k]=count
            count=0
    return dic

topics={"Price":["cheap","expensive","price"],"Business":["gnome","gnomes"],"Harry":["harry"]}
rev = "Harry shurb did Harry cheap price price harry of the gnome gnomes"
x = topicoccurence(topics,rev)
print(x)
