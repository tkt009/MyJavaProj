public class MyArrayList<T>
{
    Object[] arr;

    int defaultSize = 10;
    int capacity = defaultSize;
    int size;

    MyArrayList(){
        arr = new Object[10];
        size = 0;
        //Integer[] a = new Integer[4];

    }

    public boolean add(T data){
        if(isFull()){
            arr = new Object[capacity*2];
            capacity = capacity;
        }
        arr[size++] = data;
        return true;
    }

    private boolean isFull(){
        //if size is 80% of defaultSize, then allocate new array
        if(size > 0.8*capacity){
            return true;
        }
       return false;
    }





}
