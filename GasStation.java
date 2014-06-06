public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     
     int[] diff = new int[gas.length];
     int[] sum = new int[gas.length];
    
     for(int i = 0; i< gas.length;i++)
         diff[i] = gas[i] - cost[i];
    
    int temp =0;
    for(int i = 0; i< gas.length;i++)
         temp += diff[i];
         
    if(temp <0)
    return -1;
    
    // can do this because of the uniqueness of the answer
    // in the path each sum element should be non negative
    int seqSum =0;
    int startIndex =0;
    for(int i =0; i< gas.length;i++){
        seqSum += diff[i];
        if(seqSum <0){
            startIndex = i+1;
            seqSum =0;
        }
    }
    return startIndex;
    }
}