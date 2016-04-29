import java.util.Arrays;
// segmented
public class segmentedsieve {
    void SegmentedSieve(int L, int U)
    {
        int d=U-L+1;
        boolean flag[]=new boolean[d];
        Arrays.fill(flag, true);
        int j=L%2!=0 ? 1 : 0;
        for(int i=j;i<d;i+=2)
            flag[i]=false;
        for(int i=3;i*i<=U;i+=2)
        {
            j=(L/i)*i; //nearest multiple of i
            if(j<L)
                j+=i;
            for(j=j-L;j<d;j+=i)
                flag[j]=false;
        }
        for(int i=0;i<d;i++)
            if(flag[i])
                System.out.println(L+i);
    }
}