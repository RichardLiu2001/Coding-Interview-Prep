class Solution {

    private static int multiprocessorSystem(int[] ability, int num, int processes) {
        int count=0;
    // PriorityQueue start
        PriorityQueue<Integer> pq=new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int num1 :ability){
            pq.add(num1);
        }
        while(processes>0){
            int process=pq.poll();
            processes -=process;
            count++;
            pq.add(process/2);
        }
    // PriorityQueue end
    // simple start
    /*while(processes>0){
        Arrays.sort(ability);
        int process=ability[ability.length-1];
        processes -=process;
        count++;
        ability[ability.length-1]=process/2;
    }*/
    // simple end
        return count;
    }


}