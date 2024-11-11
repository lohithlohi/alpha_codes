import java.util.HashMap;

public class Iternery {

    public static String getStart(HashMap<String, String> tickets){
        /*
         * we need to find a from-(key) which is NOT IN to-(value)
         * this from is starting city point
         */
        // creating reverse map
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);  // value -> key
        }

        // compare keys in tickets and revmap
        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("chennai", "banglore");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");
        
        String start = getStart(tickets);

        System.out.print(start);

        for (@SuppressWarnings("unused") String key : tickets.keySet()) {   // just for name sake !!
            System.out.print(" -> "+tickets.get(start));
            start = tickets.get(start);   //update to next start
        }
    }
}
