class Solution:

    def can_merge(self, interval1, interval2):

        return interval2[0] <= interval1[1]

    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        if len(intervals) == 0:
            return []

        if len(intervals) == 1:
            return intervals

        # sort by starting time of each interval
        intervals.sort(key=lambda x: x[0])

        result = []

        current_merged_interval = intervals[0]

        for i in range(1, len(intervals)):

            current_interval = intervals[i]

            if self.can_merge(current_merged_interval, current_interval):

                current_merged_interval = [current_merged_interval[0], max(current_merged_interval[1], current_interval[1])]

            else:
                result.append(current_merged_interval)
                current_merged_interval = current_interval


        result.append(current_merged_interval)


        return result





