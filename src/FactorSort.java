
import java.util.*;

class Solution {
    public void calculate(Integer[] array)
    {
        int[] factors = new int[array.length];
        for (int i=0;i<array.length;i++)
        {
            int temp=array[i];
            int limit=(int)Math.sqrt(temp);
            HashSet<Integer>set= new HashSet<>();
            for (int j=1;j<=limit;j++)
            {
                if (temp%j==0)
                {
                    set.add(j);
                    set.add(temp/j);
                }
            }
            factors[i]=set.size();
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
        {
            indices.add(i);
        }
        indices.sort(new FactorComparator(factors,array));
        Integer[] sortedArray = new Integer[array.length];
        for(int i=0;i<array.length;i++)
        {
            sortedArray[i] = array[indices.get(i)];
        }
        for(int num:sortedArray)
        {
            System.out.print(num + " ");
        }
    }
    static class FactorComparator implements Comparator<Integer>
    {
        private final int[] factors;
        private final Integer[] array;
        public FactorComparator(int[] factors,Integer[] array)
        {
            this.factors = factors;
            this.array=array;
        }

        @Override
        public int compare(Integer num1, Integer num2)
        {
            int num1Factors = factors[num1];
            int num2Factors = factors[num2];
            if (num1Factors != num2Factors)
            {
                return Integer.compare(num1Factors, num2Factors);
            }
            else
            {
                return Integer.compare(array[num1], array[num2]);
            }
        }
    }
}

public class FactorSort
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        Integer[] array=new Integer[n];
        for (int i=0;i<n;i++)
        {
            array[i]=scanner.nextInt();
        }
        Solution solution = new Solution();
        solution.calculate(array);
    }
}
