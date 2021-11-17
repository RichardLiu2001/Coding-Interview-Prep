class Solution:


    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        
        if len(intervals) < 2:
            return len(intervals)

        intervals.sort(key=lambda x:x[0])

        # stores the ending times of all rooms that have been allocated at some point, 
        # sorted by the earliest ending time of the last meeting that was in the room
        allocated_rooms = []

        for interval in intervals:

            current_room_start = interval[0]
            current_room_end = interval[1]

            # if there's no allocated rooms yet, allocate one
            if len(allocated_rooms) == 0:

                heapq.heappush(allocated_rooms, current_room_end)
                continue

            # the earliest ending time of all meetings before the current is stored
            # at the front of the queue of allocated rooms
            earliest_ending_time = allocated_rooms[0]


            # if the earliest ending time is before the current room's start,
            # we can reuse the room, so update it with the new ending time (pop and push back with new time)
            if earliest_ending_time <= current_room_start:
                heapq.heappop(allocated_rooms)


            # if a new room is assigned, we want to add it to the heap
            # if an old room is freed up and reused, we want to add it back 
            # with the new ending time
            heapq.heappush(allocated_rooms, current_room_end)

        return len(allocated_rooms)


    def minMeetingRoomsStartEnd(self, intervals: List[List[int]]) -> int:
        
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