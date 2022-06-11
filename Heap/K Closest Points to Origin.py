class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        point_max_heap = [Point(p[0], p[1]) for p in points]

        heapq.heapify(point_max_heap)

        result = []

        for _ in range(k):

            current_closest_point = heapq.heappop(point_max_heap)

            result.append([current_closest_point.x, current_closest_point.y])

        return result

    def kClosestLeetCode(points, k):

        point_max_heap = []

        for i in range(k):

            current_point = points[i]
            point_max_heap.append(Point(current_point[0], current_point[1]))


        for i in range(k, len(points)):

            current_point = points[i]





class Point:

    def __init__(self, x, y):

        self.x = x
        self.y = y

    def __lt__(self, other_point):

        return self.euclidean_distance() < other_point.euclidean_distance()

    def euclidean_distance(self):

        return self.x ** 2 + self.y ** 2
