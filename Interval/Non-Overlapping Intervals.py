class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        
        if len(intervals) < 2:

            return 0

        intervals = sorted(intervals, key=lambda x: (x[0], x[1]))

        intervals_to_remove = 0

        # stores the last interval that we have processed so far
        # the latest starting interval that doesn't "overlap" with any others

        # we didn't actually remove overlaps, but we will count them as per the problem
        # we have "removed overlaps" for all intervals before the last interval
        last_interval = intervals[0]

        for i in range(1, len(intervals)):

            current_interval = intervals[i]

            # current interval starts before the last interval ends: overlap
            if current_interval[0] < last_interval[1]:

                # current interval ends before last interval
                # keep current interval, remove last interval and replace it with current
                if current_interval[1] < last_interval[1]:
                    last_interval = current_interval 

                # if the current interval ends after the last interval, 
                # we keep the last interval and remove the current interval
                # this does not change the last_interval variable

                # in either case of overlap, we always remove an interval: either the 
                # current or last interval
                intervals_to_remove += 1

            # if the intervals don't overlap, update the last interval to the current
            else:

                last_interval = current_interval

        return intervals_to_remove