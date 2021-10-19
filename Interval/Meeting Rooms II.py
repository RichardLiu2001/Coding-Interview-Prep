class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        if len(intervals) < 2:
            return len(intervals)

        # stores the starting times of all intervals
        starting_times = []

        # stores the ending times of all intervals
        ending_times = []

        for interval in intervals:

            starting_times.append(interval[0])
            ending_times.append(interval[1])

        starting_times.sort()
        ending_times.sort()

        current_room_count = 0
        max_rooms = 0

        starting_time_index = 0
        ending_time_index = 0

        while starting_time_index < len(intervals) and ending_time_index < len(intervals):

            # the time that the next interval starts
            current_starting_time = starting_times[starting_time_index]

            # the ending time of the last meeting
            current_ending_time = ending_times[ending_time_index]

            # the current room starts before the last meeting ends (overlap)
            if current_starting_time < current_ending_time:
                # we need to allocate a new room
                current_room_count += 1
                max_rooms = max(max_rooms, current_room_count)
                starting_time_index += 1

            # the last meeting ends before the next interval starts
            else:
                # a room is freed up
                current_room_count -= 1
                ending_time_index += 1


        return max_rooms