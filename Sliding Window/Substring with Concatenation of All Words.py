class Solution:
    
    # given a substring, return whether it can be made up of the words in the word_freqs dictionary
    def substringMatch(self, substring, word_freqs, words_remaining, word_len):

        # Naïve approach
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


    def slidingWindow(self, left, s, word_length, words, original_word_freqs, result):

        total_words = len(words)

        substring_length = word_length * total_words

        window_used_freqs = collections.defaultdict(int)

        words_used_in_window = 0

        duplicate_in_window = False


        for right in range(left, len(s), word_length):
            if right + word_length > len(s):
                break

            current_substring = s[right:right+word_length]


            if current_substring not in original_word_freqs:
                # mismatch, reset sliding window, words_used_in_window,
                left = right + word_length
                words_used_in_window = 0
                window_used_freqs = collections.defaultdict(int)
                duplicate_in_window = False

            else:
                # match

                window_used_freqs[current_substring] += 1
                if window_used_freqs[current_substring] <= original_word_freqs[current_substring]:
                    words_used_in_window += 1

                    if words_used_in_window == total_words:
                        result.append(left)

                else:
                    duplicate_in_window = True

                # continually shrink window until we are under the substring length and there are no duplicates in the window
                while right - left == substring_length or duplicate_in_window:

                    leftmost_word = s[left:left+word_length]

                    # shrink window
                    left += word_length

                    window_used_freqs[leftmost_word] -= 1
                    if window_used_freqs[leftmost_word] == original_word_freqs[leftmost_word]:
                        duplicate_in_window = False
                    else:
                        words_used_in_window -= 1


    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        result = []
        
        if len(words) == 0:
            return result
        
        word_length = len(words[0])
        original_word_freqs = collections.Counter(words)

        for i in range(0, word_length):
            self.slidingWindow(i, s, word_length, words, original_word_freqs, result)

        return result
