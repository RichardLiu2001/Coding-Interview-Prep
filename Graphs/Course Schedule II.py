class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Maps each course to the courses you can take after it (the 
        # courses that have it as a prereq)
        # This is how we represent the course prereq relationships as a graph (adjacency list)
        next_courses = defaultdict(list)

        for course, prereq in prerequisites:
            next_courses[prereq].append(course)

        

        # Topological ordering (which order you need to take) of the courses 
        course_ordering = []