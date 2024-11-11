import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {

    static class jobs {
        int idx, deadline, profit;

        jobs(int i, int d, int p) {
            idx = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobsinfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } }; // {deadline, profit}

        ArrayList<jobs> job = new ArrayList<>(); // arraylist of type job objects

        // storing jobsinfo data in arraylist of job objects
        for (int i = 0; i < jobsinfo.length; i++) {
            job.add(new jobs(i, jobsinfo[i][0], jobsinfo[i][1]));
        }

        /* sorting job objects according to profits in arraylist in descending
         order(obj2-obj1) vise versa */
        Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0, prf = 0;

        for (int i = 0; i < job.size(); i++) {
            if (time < job.get(i).deadline) {
                seq.add(i);
                prf += job.get(i).profit;
                time++; // next secound increment
            }
        }

        System.out.println("Max no. of jobs: " + seq.size());
        System.out.println("Max profit: " + prf);
        System.out.println("Jobs are: " + seq);

    }
}
