class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Maps each course to the courses you can take after it (the 
        # courses that have it as a prereq)
        # This is how we represent the course prereq relationships as a graph (adjacency list)
        course_graph = defaultdict(list)

        for course, prereq in prerequisites:
            course_graph[prereq].append(course)

        # Topological ordering (which order you need to take) of the courses 
        course_ordering = []

        # Stores the courses that have no future prereq conflicts (nodes where if you run DFS from them, 
        # there is no cycle)
        verified = set()

        for course in range(numCourses):

            if self.contains_cycle(course, verified, course_graph, set(), course_ordering):
                return []

        # Our graph stores edges as prereq -> course. Thus, when we run DFS, we will add the more "advanced" 
        # (further down recursion) courses before the easy (prereq) ones. Since we need the opposite order for
        # the actual order you need to take the classes (prereqs first), we reverse the ordering.
        return course_ordering[::-1]


    # Runs DFS from the current course and returns whether or not there is a cycle.
    # Also, once the course is verified as not having a cycle from it, adds the course to verified.
    def contains_cycle(self, course, verified, course_graph, current_path, course_ordering):

        if course in verified:
            return False

        # We encountered this course on our current path, meaning there is a cycle.
        if course in current_path:
            return True

        current_path.add(course)

        for next_course in course_graph[course]:

            if self.contains_cycle(next_course, verified, course_graph, current_path, course_ordering):
                return True

        # current_path.remove(course)

        verified.add(course)

        # We have verified that tbis course (and courses stemming from it) works, so we can add it to the ordering.
        course_ordering.append(course)

        return False

