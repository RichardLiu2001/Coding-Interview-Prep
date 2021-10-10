class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int front;
    private int back; // index of the last occupied spot
    private int[] con;

    public MyCircularQueue(int k) {
        con = new int[k];
        front = 0;
        back = 0;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        int insertIndex = (back + 1) % con.length;
        if (insertIndex >= front) {
            return false; 
        } 
        con[insertIndex] = value;
        back = insertIndex;
        return true;

    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (back == front) {
            return false;
        }

        if (back == 0) {
            back = con.length - 1;
        } else {
            back --;
        }
        return true;

    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return con[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return con[back];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == back;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (back + 1) % con.length == front; 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */