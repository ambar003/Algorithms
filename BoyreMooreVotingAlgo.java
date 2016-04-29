public class BoyreMooreVotingAlgo {
	 public static int majorityElement(int[] num) {
		         int n = num.length;
		          int candidate = num[0], counter = 0;
		          for (int i : num) {
		              if (counter == 0) {
		                  candidate = i;
		                  counter = 1;
		             } else {
		                 if (i == candidate) {
		                     counter++;
		                 } else {
		                     counter--;
		                 }
		             }
		         }
		 
		         counter = 0;
		         for (int i : num) {
		             if (i == candidate) counter++;
		         }
		         if (counter < (n + 1) / 2) return -1;
		         return candidate;
		 
		    }
		     public static void main(String[] args) {
		    	 int[] arr={3,5,6};
		         System.out.format("%d\n", majorityElement(arr));
		     }
}