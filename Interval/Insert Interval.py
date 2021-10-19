class Solution:

    def overlap(self, interval1, interval2):

        # interval 2 start between interval 1 start and interval end
        if interval2[0] >= interval1[0] and interval2[0] <= interval1[1]:
            return True

        # interval 1 start between interval 2 start and interval end
        if interval1[0] >= interval2[0] and interval1[0] <= interval2[1]:
            return True

        return False


    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        result = []

        i = 0

        # skip to the first interval that overlaps with the new interval
        
        # skip intervals where the end of the interval is before the start of the new interval
        while i < len(intervals) and intervals[i][1] < newInterval[0]:
            result.append(intervals[i])
            i += 1


        # we are on the first interval that we need to merge, or at the end of the intervals

        # merge the new interval with all intervals that overlap with it
        while i < len(intervals) and self.overlap(intervals[i], newInterval):
        #while i < len(intervals) and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])

            i += 1


        # either i is at the end, or it's on the first interval that doesn't overlap with the new interval

        # add the new interval
        result.append(newInterval)

        # add the rest of the intervals that cannot be merged
        while i < len(intervals):

            result.append(intervals[i])

            i += 1


        return result




