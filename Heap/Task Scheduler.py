class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # frequencies of the tasks
        frequencies = [0 for _ in range(26)]

        for t in tasks:
            frequencies[ord(t) - ord('A')] += 1
        
        frequencies.sort()

        # max frequency
        f_max = frequencies.pop()


        # maximum idle time from the tasks with the greatest frequency

        # at most n slots of idle time follow every occurrence of the maximum
        # occurring character, except for the last occurence. 
        idle_time = (f_max - 1) * n
        
        while len(frequencies) > 0 and idle_time > 0:

            # A _ _ A _ _ A -> B
            # We can occupy at most f_max - 1 (2) idle spots

            # greedily pick the next highest frequency to occupy as many 
            # remaining idle slots as possible
            next_highest_frequency = frequencies.pop()

            idle_time -= min(f_max - 1, next_highest_frequency)

            # if we filled all the idle time, we can stop
            # if the idle time is negative, that means that we used all of 
            # the idle time and we have some tasks left over, which will
            # just go at the end of the already assigned tasks and will 
            # not create nor take up more idle time
        
            idle_time = max(0, idle_time)

        return idle_time + len(tasks)


    def leastIntervalMath(self, tasks: List[str], n: int) -> int:

        task_frequencies = Counter(tasks)

        max_freq = max(task_frequencies, key=task_frequencies.get)

        tasks_with_max_freqs = 0

        for task in task_frequencies:

            if task_frequencies[task] == max_freq:
                tasks_with_max_freqs += 1



