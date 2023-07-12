import java.util.ArrayList;
import java.util.List;

public class MyProg
{
    public static int removeDuplicates(int[] arr){
        int j = 0;
        int i=0;
        for(;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[i];
        return j;

    }

    public static void main (String[] args)
    {
        int arr[] = {1,1,2,2,3,3,3,3,3};
        int k = removeDuplicates(arr);
        System.out.println("Uniques count: "+k);
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }

        System.out.println("sadsa");
        String aa = "wwwbbb".replaceFirst("www", "ww");
        //System.out.println(gameWinner("wwwbb"));
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(4);
        skills.add(5);
        skills.add(6);
        skills.add(10);


        int minLevel = 4;
        int maxLevel = 10;
        int minPlayers = 3;
        int teams=0;
        skills.removeIf(skill->{
            return skill< minLevel || skill > maxLevel;
        });
        int totalAva = skills.size();
        for(int n = minPlayers; n<=skills.size();n++){
            teams += factorial(totalAva)/(factorial(n) * factorial(totalAva-n));
            //totalAva = totalAva-1;
        }

        System.out.println("total teams "+teams);
    }

    public static int factorial(int a){
        if(a==0){
            return 1;
        }
        int num = a;
        for(int i=a-1;i>1;i--){
            num = num*i;
        }
        return num;
    }

        public static String gameWinner (String colors){
        // Write your code here
        String player = null;
        String p1 = "wendy";
        String p2 = "Bob";
        player = p1;
        String colorStr = colors;
        boolean continuePlaying = true;
        String wendyReplace = "www";
        String wendyReplaceWith = "ww";
        String bobReplace = "bbb";
        String bobReplaceWith = "bb";

        String replaceStr = wendyReplace;
        String replaceStrWith = wendyReplaceWith;
        String winner = "wendy";
        while (continuePlaying) {
            if (player.equals(p2)) {
                replaceStr = bobReplace;
                replaceStrWith = bobReplaceWith;
            }
            else if (player.equals(p1)) {
                replaceStr = wendyReplace;
                replaceStrWith = wendyReplaceWith;
            }
            if (colorStr.indexOf(replaceStr) > 0) {
                colorStr = colorStr.replaceFirst(replaceStr, replaceStrWith);
                player = player.equals(p1) ? p2 : p1;
            }
            else {
                continuePlaying = false;
                winner = player.equals(p1) ? p2 : p1;
            }
        }

        return winner;

    }

    }




