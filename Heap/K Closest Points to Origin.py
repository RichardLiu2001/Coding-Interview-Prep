class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        point_min_heap = [Point(p[0], p[1]) for p in points]

        heapq.heapify(point_min_heap)

        result = []

        for _ in range(k):

            current_closest_point = heapq.heappop(point_min_heap)

            result.append([current_closest_point.x, current_closest_point.y])

        return result

class Point:

    def __init__(self, x, y):

        self.x = x
        self.y = y

    def __lt__(self, other_point):

        return self.x ** 2 + self.y ** 2 < other_point.x ** 2 + other_point.y ** 2