import java.util.LinkedList;
import java.util.List;

public class MyOOM
{
    public static void main(String[] args) throws InterruptedException
    {
        int dummyArraySize = 15;
        System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
        long memoryConsumed = 0;
        try {
            long[] memoryAllocated = null;
            for(int loop = 0; loop < Integer.MAX_VALUE; loop++) {
                memoryAllocated = new long[dummyArraySize];
                memoryAllocated[0] = 0;
                memoryConsumed += dummyArraySize * Long.SIZE;
                System.out.println("Memory Consumed till now: " + memoryConsumed);
                dummyArraySize *= dummyArraySize * 2;
                Thread.sleep(500);
            }
        } catch (OutOfMemoryError | InterruptedException outofMemory) {
            System.out.println("Catching out of memory error");
            //Log the information, so that we can generate the statistics
            throw outofMemory;
        }
    }
}
