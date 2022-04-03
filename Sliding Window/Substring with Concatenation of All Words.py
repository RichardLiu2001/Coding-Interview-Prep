class Solution:
    
    def substringMatch(self, substring, word_freqs, words_remaining, word_len):
        for i in range(0, words_remaining * word_len, word_len):

            current_string = substring[i:i + word_len]
            if current_string in word_freqs:

                if word_freqs[current_string] > 0:

                    word_freqs[current_string] -= 1
                    words_remaining -= 1
                else:
                    return False

            else:

                return False

        return words_remaining == 0

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        result = []
        
        if len(words) == 0:
            return result

        word_len = len(words[0])
        
        word_freqs = Counter(words)
        
        for i in range(len(s)):

            if self.substringMatch(s[i:i+word_len * len(words)], word_freqs.copy(), len(words), word_len):

                result.append(i)

        return result
