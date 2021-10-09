class Solution:
    def alienOrder(self, words: List[str]) -> str:
        adj = {c: set() for w in words for c in w}

        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]

            minLen = min(len(w1), len(w2))

            # invalid case: w1 is longer than w2, but w2 is a prefix of w1
            if len(w1) > len(w2) and w1[:minLen] == w2[:minLen]:
                return ""

            for j in range(minLen):
                if w1[j] != w2[j]:

                    # w1[j] comes before w2[j] in the alien alphabet
                    adj[w1[j]].add(w2[j])
                    
                    # we only know for sure the lexicographical order of the first differening letters
                    break

        visited = {} # False = visited, True = part of current path

        res = []

        def dfs(c):
            if c in visited:

                # if true, then there is a loop
                return visited[c]

            visited[c] = True

            for neighbor in adj[c]:
                if dfs(neighbor):
                    # detected a loop
                    return True

            visited[c] = False

            res.append(c)


        for c in adj:
            if dfs(c):
                # loop detected
                return ""

        
        res.reverse()

        return ''.join(res)

