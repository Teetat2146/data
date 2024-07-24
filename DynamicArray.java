public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void PushBack(int data){
        // START FIX CODE HERE
        if(size == capacity){
            int[] tmp = new int[capacity*2];
            for(int i=0; i<capacity; i++){
                tmp[i] = arr[i];
            }
            capacity = capacity*2;
            arr = tmp;
            
        }
        arr[size] = data;
        size++;
        
        // END CODE HERE
    }
    public int PopBack(){
        // START FIX CODE HERE
        int tmp = arr[size - 1];
        size--;
        return tmp;
        // END CODE HERE
    }

    public int Get(int i){
        // START FIX CODE HERE
        if(i>size-1){
            System.out.print("ERROR\n");
        }
        return arr[i];
        // END CODE HERE
    }
    public void Set(int i, int value){
        // START FIX CODE HERE
        if(i>size-1){
            System.out.print("ERROR\n");
        }else arr[i] = value;
        // END CODE HERE
    }
    
    public void Remove(int i){
        // START FIX CODE HERE
        if(i>size-1){
            System.out.print("ERROR\n");
        }else {
            for(int x=i ; x<size; x++){
                arr[x] = arr[x+1];
            }
            size--;
        }
        // END CODE HERE
    }
    
    public boolean IsEmpty(){
        // START FIX CODE HERE
        return false;
        // END CODE HERE
    }
    
    public int GetSize(){
        // START FIX CODE HERE
        return size;
        // END CODE HERE
    }
    
    public void PrintStructure(){
        // START FIX CODE HERE
        if(size == 0 ){
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ]\n");
        }else {
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
            for(int i=0; i<size; i++){
                System.out.print(arr[i]);
                if(i != size-1){
                    System.out.print(", ");
                }
            }
            System.out.print(" ]\n");
        }
        // END CODE HERE
    }
}