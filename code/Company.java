package file;

import java.io.*;
import java.util.*;
class Job {
	int profit;
	int start_time;
	int end_time;

	public Job( int start_time, int end_time,int profit) {
		super();
		this.profit = profit;
		this.start_time = start_time;
		this.end_time = end_time;
	}
}
public class Company extends Job{
	public Company(int start_time, int end_time,int profit) {
		super( start_time, end_time,profit);
	}

	public static void main(String[] args) throws IOException{
	
		FileInputStream file=new FileInputStream("E:\\txtfiles\\input.txt");
		Scanner sc=new Scanner(file);
		int no_jobs=Integer.parseInt(sc.nextLine());
		ArrayList<Job> joblist=new ArrayList<Job>(no_jobs);
		while(sc.hasNextLine()) {
			joblist.add(new Job( Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine())));
		}
		int max=0;
		int earnings=0;
		for (Job emp : joblist) {
			if(max<emp.profit) {
				max=emp.profit;
			}
		}
			Job j1 = null;
		for(int i=0;i<joblist.size();i++) {
			if((joblist.get(i)).profit==max  ) {
				j1=new Job((joblist.get(i)).start_time,(joblist.get(i)).end_time,(joblist.get(i)).profit);
				joblist.remove(i);
				break;
			}
		}
		for(int i=0;i<joblist.size();i++) {
			if((joblist.get(i).start_time>=j1.end_time || joblist.get(i).end_time<=j1.start_time)) {
				j1=new Job((joblist.get(i)).start_time,(joblist.get(i)).end_time,(joblist.get(i)).profit);
				joblist.remove(i);
			}
		}
		for(int i=0;i<joblist.size();i++) {
			earnings=earnings+(joblist.get(i).profit);
		}
		
		FileWriter fw=new FileWriter("E:\\txtfiles\\output.txt");
		BufferedWriter bw =new BufferedWriter(fw);
		bw.write("The number of tasks and earnings available for others");
		bw.write("\nTask :"+joblist.size());
		bw.write("\nEarning :"+earnings);
		bw.close();
		sc.close();
	 }
}

