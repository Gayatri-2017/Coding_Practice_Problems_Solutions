
business_names = [ "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut","pizza fateh"]
searchTerm = "duper bur"
res = []
for i in business_names:
    split_name = i.split()
    searchtermsplit = searchTerm.split()
    count = 0
    for words in split_name:
        for search1 in searchtermsplit:
            if(words.startswith(search1)):
                count+=1
    if(count >= 1 and count == len(searchtermsplit)):
        res.append(' '.join(split_name))
print(res)
