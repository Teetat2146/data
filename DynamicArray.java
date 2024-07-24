public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void PushBack(int data){
        if(size == capacity){ //สร้าง array ใหม่ 
            int[] tmp = new int[capacity*2];
            for(int i=0; i<capacity; i++){
                tmp[i] = arr[i];
            }
            capacity = capacity*2;
            arr = tmp;
            
        }
        arr[size] = data; //เพิ่มค่าเข้าไปใน array
        size++;
    }
    public int PopBack(){
        int tmp = arr[size - 1]; // เอาค่าออกจาก array[]
        size--;
        return tmp;
    }

    public int Get(int i){
        if(i>size-1){ //ถ้าค่าในตำแหน่งที่ต้องการมีค่ามากกว่าขนาดของ array
            System.out.print("ERROR\n");
        }
        return arr[i]; //ต่าในตำแหน่วที่ต้องการ
    }
    public void Set(int i, int value){
        if(i>size-1){
            System.out.print("ERROR\n");
        }else arr[i] = value; // set ค่าในตำแหน่งที่ต้องการให้เป็น value
    }
    
    public void Remove(int i){
        if(i>size-1){
            System.out.print("ERROR\n");
        }else {
            for(int x=i ; x<size; x++){ //เอาค่าถัดจากค่าที่ต้องการลบออกมาแทนที่ค่าที่ต้องการลบออก แล้วเลื่อนไปเรื่อยๆ
                arr[x] = arr[x+1];
            }
            size--;
        }
    }
    
    public boolean IsEmpty(){
        if(size != 0 ){ //เช็คว่าว่างไม่ว่างจาก size
            return true;
        }else return false; 
    }
    
    public int GetSize(){
        return size; // หา size
    }
    
    public void PrintStructure(){
        if(size == 0 ){
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ]\n");
        }else {
            System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
            for(int i=0; i<size; i++){
                System.out.print(arr[i]); // print ค่าใน array
                if(i != size-1){
                    System.out.print(", ");
                }
            }
            System.out.print(" ]\n");
        }
    }
}