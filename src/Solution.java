import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(SinglyLinkedListNode node) {
        //SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}


class Result {

    /*
     * Complete the 'findRepeatingFilter' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST integerLinkedList as parameter.
     */



    public static int findRepeatingFilter(SinglyLinkedList integerLinkedList) {
        String check = "";
        int repeat = -1;
        SinglyLinkedListNode curr = integerLinkedList.head;
        while(curr.next!=null){
            int d = curr.data;
            if(check.contains(String.valueOf(d))){
                repeat = d;
                break;
            }else{
                check = check+ String.valueOf(d);
            }
            curr = curr.next;
        }

        return repeat;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
//        //

        SinglyLinkedList integerLinkedList = new SinglyLinkedList();
        HashMap<Integer, SinglyLinkedListNode> h = new HashMap<Integer, SinglyLinkedListNode>();
        integerLinkedList.insertNode(new SinglyLinkedListNode(5));
        integerLinkedList.insertNode(new SinglyLinkedListNode(6));
        integerLinkedList.insertNode(new SinglyLinkedListNode(7));
        integerLinkedList.insertNode(new SinglyLinkedListNode(8));
        integerLinkedList.insertNode(new SinglyLinkedListNode(5));
        integerLinkedList.insertNode(new SinglyLinkedListNode(6));
        integerLinkedList.insertNode(new SinglyLinkedListNode(3));


        //int listOfFiltersCount = Integer.parseInt(bufferedReader.readLine().trim());

//        IntStream.range(0, listOfFiltersCount).forEach(i -> {
//            try {
//                int filterID = Integer.parseInt("567589");
//
//                if (!h.containsKey(filterID)) {
//                    h.put(filterID, new SinglyLinkedListNode(filterID));
//                }
//                integerLinkedList.insertNode(h.get(filterID));
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        });

        int result = Result.findRepeatingFilter(integerLinkedList);

       System.out.println(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
