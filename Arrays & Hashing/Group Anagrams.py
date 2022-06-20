class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        anagram_map = defaultdict(list)

        for s in strs:

            current_freq_map = self.get_freq_map(s)

            anagram_map[current_freq_map].append(s)

        # returns a 'view' object of the values of the dictionary
        # it can be turned into a list via list(), but the view works for the solution.
        return anagram_map.values()


    def get_freq_map(self, s):

        freqs = [0 for _ in range(26)]

        for char in s:

            freqs[ord(char) - ord('a')] += 1

        # must turn the list into a tuple - you can hash a tuple, but
        # you cannot hash a list or dictionary
        return tuple(freqs)