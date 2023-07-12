import java.util.Arrays;

public class MsInti
{
    /**
     * MY NAME IS TULASI
     * output: TULASI IS NAME MY
     * 0(n) time
     * space 0(1)
     */
    public static void  swap(int a, int b, char[] arr){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void printReverseWordwise(char[] input){
        int pointer1 =0;
        int p2 = input.length-1;
        while(p2> pointer1){
            swap(pointer1,p2,input);
            pointer1++;
            p2--;
        }

        //now reverse each word
        pointer1 =0;
        p2=0;
        for(int i = pointer1; i< input.length; i++){
            if(input[i]!=' ')
                continue;
            p2 = i-1;
            reverseWord(pointer1, p2,input);
            pointer1 = p2+2;
        }
        if(pointer1<input.length-1){
            p2 = input.length-1;
            reverseWord(pointer1,p2,input);
        }

        System.out.println("");
        //now print it
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
    }

    /**
     * reverses chars from index1 to index2
     * @param index1
     * @param index2
     * @param arr
     */
    public static void reverseWord(int index1, int index2, char[] arr){
        int p1 =index1;
        int p2 = index2;
        while(p2>p1){
            swap(p1,p2,arr);
            p1++;
            p2--;
        }
    }

    public static void main(String[] args){
        char[] inputString = "MY NAME IS TULASI".toCharArray();

        MsInti i = new MsInti();
        i.printReverseWordwise(inputString);


    }
}
