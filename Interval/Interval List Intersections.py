class Solution:

    def intersect(self, interval1, interval2):

        # intersection means one of the starting points lies within the range of the other interval

        # starting point of interval 1 is within interval 2
        if interval1[0] >= interval2[0] and interval1[0] <= interval2[1]:
            return True

        # starting point of interval 2 is within interval 1
        if interval2[0] >= interval1[0] and interval2[0] <= interval1[1]:
            return True

        return False


    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        
        result = []

        # index of the interval under consideration in the first list
        first_index = 0

        # index of the interval under consideration in the second list
        second_index = 0

        while first_index < len(firstList) and second_index < len(secondList):

            first_interval = firstList[first_index]
            second_interval = secondList[second_index]

            # if the two intervals intersect, find the intersection and add to result

            # then, we want to advance the interval that ends earlier, because the interval 
            # that ends later potentially could still intersect with another interval in the 
            # remaining portion. 

            # given an interval with the earliest ending time (out of both lists), it can 
            # at most intersect with one other interval, because the intervals in each list are disjoint.

            # after we process the earliest ending interval, we can advance the index for that list
            # because we know it cannot intersect with any interval other than the intersected interval that
            # we just considered

            if self.intersect(first_interval, second_interval):

                result.append([max(first_interval[0], second_interval[0]), min(first_interval[1], second_interval[1])])

            # if the two intervals do not intersect, one of them is completely
            # ahead of the other

            # we want to advance the one behind, otherwise there will never be any
            # future opportunities to find intersections

            # thus, in either case of intersection or not, we want to advance
            # whichever interval ends first
            if first_interval[1] < second_interval[1]:

                first_index += 1

            else:

                second_index += 1

        return result