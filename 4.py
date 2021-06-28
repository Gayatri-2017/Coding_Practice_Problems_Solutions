# public static float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
#         float start = queryTimeRange.start;
#         float end = queryTimeRange.end;
#
#         float overlap = 0.0f;
#         for (TimeRange timeRange: openHours){
#             float overlapStart = Math.max(start, timeRange.start);
#             float overlapEnd = Math.min(end, timeRange.end);
#             float value = overlapEnd - overlapStart;
#             if (value>0){
#                 overlap+= value;
#             }
#         }
#
#         return  overlap/(end-start);
#     }

# res = []
#         def dfs(node, dist):
#             visited.add(node)
#             if dist <= target:
#                 res.append(node)
#
#             for n in node.neighbors:
#                 if n not in visited:
#                     dfs(n, dist + n.distance)
#
#         def getClosetK(start):
#             visited = set()
#             dfs(start, 0)
#             return [node.name for node in res if node.name != start.name]
