class Codec:

    def encode(self, strs: List[str]) -> str:
        """Encodes a list of strings to a single string.
        """
        code = ""

        # code will be length of next string (delimited by '#')
        # e.g [LeBron, James, SUPERLONGWORD] -> 5#Lebron4#James13#SUPERLONGWORD
        # need # delimiter for word length because the length of string could be > 1 digit

        for s in strs:

            code += str(len(s)) + "#" + s

        return code
        

    def decode(self, s: str) -> List[str]:
        """Decodes a single string to a list of strings.
        """

        result_string_list = []

        i = 0

        while i < len(s):

            # index to find length of string up to delimiter
            delim_index = i

            while s[delim_index] != '#':
                delim_index += 1
            # delim_index is on the delimiter '#'

            string_length = int(s[i:delim_index])

            # string starts on delim_index + 1
            next_string = s[delim_index + 1 : delim_index + 1 + string_length]

            result_string_list.append(next_string)

            i = delim_index + 1 + string_length

        return result_string_list
        


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))