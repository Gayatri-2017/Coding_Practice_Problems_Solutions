

# Sample Input
# {
# "businessOfInterestId": 10,
# "positiveReviews": [
# PositiveReview(
# "userId": 1,
# "businessId": 10
# ),
# PositiveReview(
# "userId": 2,
# "businessId": 10
# ),
# PositiveReview(
# "userId": 1,
# "businessId": 11
# ),
# PositiveReview(
# "userId": 2,
# "businessId": 11
# ),
# PositiveReview(
# "userId": 1,
# "businessId": 12
# ),
# PositiveReview(
# "userId": 2,
# "businessId": 12
# ),
# PositiveReview(
# "userId": 3,
# "businessId": 12
# )
# ]
# }
import json

# some JSON:
# x =  '{ "businessOfInterestId":10, "positiveReviews":[ PositiveReview( "userId":1, "businessId":10 ), PositiveReview( "userId":2, "businessId":10 ), PositiveReview( "userId":1, "businessId":11 ), PositiveReview( "userId":2, "businessId":11 ), PositiveReview( "userId":1, "businessId":12 ), PositiveReview( "userId":2, "businessId":12 ), PositiveReview( "userId":3, "businessId":12 ) ] }'
#
# # parse x:
from collections import defaultdict
# y = json.loads(x)
class Solution :
    dict = defaultdict(set)
    dict[10].add(1)
    dict[10].add(2)
    dict[10].add(3)
    dict[10].add(1)
    dict[11].add(2)
    dict[12].add(1)
    dict[12].add(2)
    dict[12].add(3)
    boi = 10
    max_business,max_sum = None,float('-inf')
    boi_business_users = dict[boi]

    for key,value in dict.items():
        if(key == boi):
            continue
        user_business = dict[key]
        sim = len(user_business.intersection(boi_business_users))/len(user_business.union(boi_business_users))
        print(sim)
        if(sim > max_sum):
            max_sum = sim
            max_business = key

    print(max_business)


