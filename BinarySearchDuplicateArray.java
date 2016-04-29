public class BinarySearchDuplicateArray {
	public static void main(String[] args) {
	  int[] arr={5,5,7,7,7,8,9,10};
	  int key=6;
      int left=leftPosition(arr, -1, arr.length-1,key);
      int right= Rightposition(arr, 0, arr.length, key);
      System.out.println(left+1+" "+(right+1));
	}
	static int Rightposition(int[] arr,int l,int r, int key) {
     int mid;
     while(r-l>1){
    	 mid=l+(r-l)/2;
    	 if(arr[mid]<=key){
    		 l=mid;
    	 }
    	 else
    		 r=mid;
     }
     return l;
	}
	static int leftPosition(int[] arr,int l,int r, int key) {
		 int m;
		    while( r - l > 1 )
		    {
		        m = l + (r - l)/2;
		        if( arr[m] >= key )
		            r = m;
		        else
		            l = m;
		    } 
		    return r;
	}
}