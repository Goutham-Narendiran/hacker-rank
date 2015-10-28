package com.interview.array;


class Bucket{
	int high ;
	int low ;
	
	public Bucket(){
		high=-1;
		low = -1;
	}
}
public class NumDiff {
public static int numDiff(int arr[]){
	if(arr == null || arr.length<2)
		return 0;
	int max = arr[0];
    int min = arr[0];

    for(int i=1; i<arr.length; i++){
        max = Math.max(max, arr[i]);
        min = Math.min(min, arr[i]);
    }
        Bucket[] buckets = new Bucket[arr.length+1];
        for(int i1=0; i1<buckets.length; i1++){
            buckets[i1] = new Bucket();
        }
        
        double interval = (double) arr.length / (max - min);
        
        for(int i1=0; i1<arr.length; i1++){
            int index = (int) ((arr[i1] - min) * interval);
     
            if(buckets[index].low == -1){
                buckets[index].low = arr[i1];
                buckets[index].high = arr[i1];
            }else{
                buckets[index].low = Math.min(buckets[index].low, arr[i1]);
                buckets[index].high = Math.max(buckets[index].high, arr[i1]);
            }
        }
        
        
        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for(int i1=1; i1<buckets.length; i1++){
            if(buckets[i1].low != -1){
                result = Math.max(result, buckets[i1].low-prev);
                prev = buckets[i1].high;
            }
     
        }
     
        return result;
	
}

public static void main(String...args){
	int arr[] = {1,16,17,81,17};
	System.out.println(numDiff(arr));
}
}
