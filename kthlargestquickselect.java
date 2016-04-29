// using quick select variation of quick sort we can find kth smallest or largest element in given array
// Time complexity:- average O(n)
// worst case:- O(n2)
public class kthlargestquickselect {
	 public static int kthElement(int arr[],int k){
	        int low = 0;
	        int high = arr.length-1;
	        int pos =0;
	        while(true){
	            pos = quickSelect(arr,low,high);
	            if(pos == (k+low)){
	                return arr[pos];
	            }
	            if(pos > k){
	                high = pos-1;
	            }else{
	                low = pos+1;
	                k = k - low;
	            }
	        }
	    }
	    
	    private static int quickSelect(int arr[],int low,int high){
	        int pivot = low;
	        low++;
	        while(low <= high){
	            if(arr[pivot] > arr[low]){
	                low++;
	                continue;
	            }
	            if(arr[pivot] <= arr[high]){
	                high--;
	                continue;
	            }
	            swap(arr,low,high);
	        }
	        if(arr[high] < arr[pivot]){
	            swap(arr,pivot,high);
	        }
	        return high;
	    }
	    
	    private static void swap(int arr[],int low,int high){
	        int temp = arr[low];
	        arr[low] = arr[high];
	        arr[high] = temp;
	    }
	    
	    public static void main(String args[]){
	        int arr[] = {3,6,9,1,2};
// if we want to know Kth largest then we should pass K-1 as argument.	        
	        System.out.print(kthElement(arr,4));
	    }
}
