class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # Maps each course to the courses you can take after it (the 
        # courses that have it as a prereq)
        # This is how we represent the course prereq relationships as a graph (adjacency list)
        next_courses = defaultdict(list)

        for next_course, prerequisite in prerequisites:

            next_courses[prerequisite].append(next_course)

        # Stores courses whose next courses can be reached with no prereq conflicts.
        # This prevents rechecking nodes - if node B is valid, and A is a prereq of B, 
        # when we check A, we don't need to check B again.
        verified = set()

        for course in range(numCourses):

            # We have to run DFS from every course because there could be 
            # unconnected components.
            if self.contains_cycle(course, set(), verified, next_courses):
                return False

        return True

    # Runs DFS from the current course and returns whether or not a cycle
    # was found. 
    # Corresponds to answering the question, "If I start with the current_course, 
    # will any next courses have impossible prereq conflicts?"
    # We use a set to "breadcrumb" our current_path - we keep track of the current
    # path that we're on, and if we reach a node that's on it, we know that there is a cycle.
    def contains_cycle(self, current_course, current_path, verified, next_courses):

        if current_course in verified:
            return False

        if current_course in current_path:
            return True

        current_path.add(current_course)

        for next_course in next_courses[current_course]:

            if self.contains_cycle(next_course, current_path, verified, next_courses):
                return True

        # Remove the current node from the current path because it is no longer on 
        # the current path when we go check other paths.
        # NOTE: this is a special case where we don't actually need to do this. The 
        # current_path acts as our visited set in DFS, and if we encounter an already visited 
        # node, we know that there is a cycle and break out of the DFS immediately. Thus,
        # it doesn't matter if we don't remove it from the current path - the DFS is going to end
        # and return True (there is a cycle).

        # In the normal case of DFS, we don't break out of the entire DFS - 
        # we just use the visited set to know not to visit those nodes again.
        current_path.remove(current_course)

        # Mark this node as verified, so we don't recheck it in future DFS's.
        verified.add(current_course)

        return False