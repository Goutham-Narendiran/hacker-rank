package com.interview.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Job{
	int id;
	int startTime;
	int endTime;
	int value;
	public Job(int i,int s,int e, int v){
		id=i;
		startTime = s;
		endTime = e;
		value = v;
	}
}

class JobComparator implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		return o1.endTime-o2.endTime;
	}
	
}
public class DP_Weighted_Job_Scheduling {
static	ArrayList<Job> selectedJobs = new ArrayList<>();
public static void main(String[] args) {
	ArrayList<Job> list = new ArrayList<>();
	list.add(new Job(2,1,5,4));
	list.add(new Job(4,3,8,7));
	list.add(new Job(5,7,10,2));
	list.add(new Job(6,8,11,1));
	list.add(new Job(1,0,3,2));
	list.add(new Job(3,4,6,4));

	Collections.sort(list,new JobComparator());
	System.out.println(findBestSchedule(list));;
	selectedJobs.forEach(i -> System.out.println(i.id));
}

private static int findBestSchedule(ArrayList<Job> list) {
	// TODO Auto-generated method stub
	int M[] = new int[list.size()+1];
	M[0]=0;
	
	for(int i = 1;i<list.size()+1;i++){
		int a = list.get(i-1).value + M[P(i-1,list)+1];
		int b = M[i-1];
//		if(a>b)
//			selectedJobs.add(list.get(i-1));
		M[i] = Math.max(a,b);
	}
	
	return M[list.size()];
}

private static int P(int i, ArrayList<Job> list) {
	// TODO Auto-generated method stub
	if(i==0)
		return -1;
	for(int j = i-1;j>=0;j--){
		if(list.get(j).endTime<=list.get(i).startTime)
			return j;
	}
	return -1;
}
}
