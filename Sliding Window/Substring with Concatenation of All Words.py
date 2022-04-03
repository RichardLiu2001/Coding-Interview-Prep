from typing import List
from collections import Counter
def findSubstring(self, s: str, words: List[str]) -> List[int]:
    result = []

    if len(words) == 0:
        return result

    word_freqs = Counter(words)

    current_remaining_words = len(words)

    word_length = len(words[0])

    left = 0

    for right in range(0, len(s), word_length):
        print("right: " + str(right))

        current_word = s[right:right + 3]
        print("current_word: " + current_word)

        if current_word in word_freqs and word_freqs[current_word] > 0:

            current_remaining_words.remove(current_word)
            print(current_word + " is in the list, removing from remaining words")
            print("remaining words: " + str(current_remaining_words))

            if len(current_remaining_words) == 0:
                print("No more remaining words, adding index " + str(left) + " to result")
                # found a concatenation
                result.append(left)

        else:

            print(current_word + " not in the list, adding all words back")


            # add all words back
            current_remaining_words.clear()
            current_remaining_words = word_set.copy()

            if current_word in current_remaining_words:
                current_remaining_words.remove(current_word)
                left = right
                right -= 3

                if len(current_remaining_words) == 0:
                # found a concatenation
                    result.append(left)
            else:

                left = right + 3




    return result

RESULT = findSubstring(None, "barfoofoobarthefoobarman", ["bar","foo","the"])
print("RESULT: " + str(RESULT))