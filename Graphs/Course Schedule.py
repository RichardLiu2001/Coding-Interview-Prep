class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # Maps each course to the courses you can take after it (the 
        # courses that have it as a prereq)
        # This is how we represent the course prereq relationships as a graph (adjacency list)
        next_courses = defaultdict(list)

        for next_course, prerequisite in prerequisites:

            next_courses[prerequisite].append(next_course)


        for course in range(numCourses):

            # We have to run DFS from every course because there could be 
            # unconnected components.
            if self.contains_cycle(course, set(), next_courses):
                return False

        return True

    # Runs DFS from the current course and returns whether or not a cycle
    # was found. 
    # Corresponds to answering the question, "If I start with the current_course, 
    # will any next courses have impossible prereq conflicts?"
    def contains_cycle(self, current_course, current_path, next_courses):

        if current_course in current_path:
            return True

        current_path.add(current_course)

        for next_course in next_courses[current_course]:

            if self.contains_cycle(next_course, current_path, next_courses):
                return True

        current_path.remove(current_course)

        return False

