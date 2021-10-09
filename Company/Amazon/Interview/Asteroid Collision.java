class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i ++) {
            int asteroid = asteroids[i];

            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {

                // current asteroid is negative (going left)
                boolean finished = false;

                while (!finished) {

                    int peek = stack.peek();

                    if (peek < 0) {
                        // two asteroids going left
                        //[-1, -1]
                        stack.push(asteroid);
                        finished = true;
                    } else if (peek == -1 * asteroid) {
                        // explode 
                        //[1, -1]
                        stack.pop();
                        finished = true;

                    } else if (peek > -1 * asteroid){

                        // [2, -1]
                        finished = true;

                    } else {
                        // peek < -1 * asteroid
                        // [1, -2], keep exploding
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            finished = true;
                        }


                    }
                }

            }

        }
        
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i --) {
            result[i] = stack.pop();
        }

        return result;

    }
}