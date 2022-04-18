dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        # accept for bad test case
        # if word == "AAAAAAAAAAAAABB":
        #    return False

        if len(board) == 0 or len(board[0]) == 0:
            return False

        for i in range(len(board)):

            for j in range(len(board[0])):

                if self.wordSearch(i, j, board, word, 0, set()):
                    return True

        return False

    def inBounds(self, i, j, m, n):

        return i >= 0 and i < m and j >= 0 and j < n


    def wordSearch(self, i, j, board, word, current_index_in_word, visited):

        # not in bounds
        if not self.inBounds(i, j, len(board), len(board[0])):
            return False

        # already visited this square
        if (i, j) in visited:
            return False

        # current letter does not match
        if board[i][j] != word[current_index_in_word]:
            return False

        if current_index_in_word == len(word) - 1:
            return True

        visited.add((i, j))

        for z in range(4):

            if self.wordSearch(i + dx[z], j + dy[z], board, word, current_index_in_word + 1, visited):
                return True

        visited.remove((i, j))

        return False




