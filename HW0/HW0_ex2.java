public class HW0_ex2
{
    /** Returns the maximum value from m. */
    public static int max(int[] m)
    {
        int max_val = m[0];
        for (int i = 1; i < m.length; i++)
        {
            if(max_val < m[i])
            {
                max_val = m[i];
            }
        }
        return max_val;
    }
    public static void main(String[] args)
    {
        int[] numbers = new int[]{9,2,15,2,22,10,6};
        int max_val = max(numbers);
        System.out.println(max_val);
    }
}