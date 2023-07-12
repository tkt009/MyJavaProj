import java.util.Date;
import java.util.Stack;

public class Abc
{
    public static void main(String[] args){
//        String s1 = "{()[]}[]";
//
//        String s2 = "{([]}";
//        Abc abc = new Abc();
//        System.out.println("s1 is balanced?: "+abc.checkIfBalanced(s1));
//        System.out.println("s2 is balanced?: "+abc.checkIfBalanced(s2));
//        Abc a = new Abc();
//        int a1 =10; int b =10;
        //a.meth(a1,b);
        String currStatus="In Progress";
        Date beginDate = new Date();
        testMeth(currStatus, beginDate);
        testMeth("Active", beginDate);
        testMeth("Scheduled", beginDate);
        testMeth("In Progreess", beginDate);
        testMeth("In Progreess", null);
        testMeth("Active", null);

        System.out.println("Test meth2");

        testMeth2(currStatus, beginDate);
        testMeth2("Active", beginDate);
        testMeth2("Scheduled", beginDate);
        testMeth2("In Progreess", beginDate);
        testMeth2("In Progreess", null);
        testMeth2("Active", null);


    }

    public static void testMeth(String currStatus, Date beginDate){
        if ((!"Active".equals(currStatus) && !"Scheduled".equals(currStatus)) && (beginDate == null)) {
            System.out.println(currStatus+" "+beginDate+" - "+"got in");
        }else{
            System.out.println(currStatus+" "+beginDate+" - "+"Did not get in");
        }
    }

    public static void testMeth2(String currStatus, Date beginDate){
        if (beginDate == null ||
            (!"Active".equals(currStatus) && !"Scheduled".equals(currStatus)) ||
            beginDate == null) {
            System.out.println(currStatus+" "+beginDate+" - "+"got in");
        }else{
            System.out.println(currStatus+" "+beginDate+" - "+"Did not get in");
        }
    }


    public String meth(int a, float b){
        return "meth1";
    }
    public String meth(float a, int b){
        return "meth2";
    }

    public boolean checkIfBalanced(String input){
        boolean balanced = true;
        Stack<Character> s = new Stack<>();
        int i =0;
        Character pushChar = input.charAt(i++);
        s.push(pushChar);
        while(!s.isEmpty()){
            Character ch = input.charAt(i++);
            if(ch.equals('{')|| ch.equals('[') || ch.equals('(')){
                s.push(ch);
            }else{
                Character pk = s.peek();
                if(isMatchingBracket(pk,ch)){
                    s.pop();
                }else{
                    balanced = false;
                    break;
                }
            }
        }
        return balanced;
    }

    private  boolean isMatchingBracket(Character a, Character b){
        boolean matching = false;
        switch (a){
        case '{':
            if(b.equals('}'))
                matching = true;
            break;
        case '[':
            if(b.equals(']'))
                matching = true;
            break;
        case '(':
            if(b.equals(')'))
                matching = true;
            break;

        }
        return matching;
    }
}
