class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        
        children = defaultdict(list)

        for parent, child in edges:

            children[parent].append(child)


        visited = set()



    def dfs(self, current_node, visited, children):

        if current_node in visited:

            

