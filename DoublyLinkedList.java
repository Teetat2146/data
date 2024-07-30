import org.w3c.dom.Node;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        //START FIX HERE
        listName = name;
        //END FIX HERE
    }
    
    public void PopTail() { // เอาตัวท้ายสุดออก
        //START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
        }else {
            if(tail == head){ //ถ้ามีตัวเดียว
                head = null;
                tail = null;
            }else{
                tail = tail.previous;
                tail.next = null;   
            }
            
        }
        //END FIX HERE
    }
    
    public void PopHead(){  //เอาตัวหน้าสุดออก
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
        }else {
            head = head.next;
            head.previous = null;
        }
        //END FIX HERE
    }
    
    public Node GetHead(){ //เอาค่าตัวหน้าสุด
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
            return head;
        }
        //END FIX HERE
    }
    
    public Node GetTail(){ //เอาค่าตัวหลังสุด
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else {
			return tail;
        }
        //END FIX HERE
    }
    
    public void PushHead(Node node){ //เอาค่าเข้าด้านหน้าสุด
        //START FIX HERE
        if (IsEmpty()) {
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        //END FIX HERE
    }
    
    public void PushTail(Node node) { //เอาค่าเข้าด้านหลังสุด
        //START FIX HERE
        if (IsEmpty()) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        //END FIX HERE
    }

    public Node FindNode(int id){ //หาตัวที่ต้องการโดยเช็ค id
        //START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        }
        else {
            Node current = head;
            while(current != null){ // loop หาตัวที่ต้องการ
                if(current.heroId == id){ // check ตัวปัจจุบันว่ามี id ตามที่ต้องการมั้ย
                    return current;
                }
                current = current.next;
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }
    
    public Node EraseNode(int id){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        Node current = head;
        while(current != null){ // loop หาตัวที่ต้องการ
            if(current.heroId == id){ // check ตัวปัจจุบันว่ามี id ตามที่ต้องการมั้ย
                if(current == head){ //ตัวที่ต้องการอยุ่หน้าสุด ให้ head ชี้ตัวถัดไป
                    head = current.next;
                    current.next.previous = null;
                }else if(current == tail){ //ตัวที่ต้องการอยุ่หลังสุด ให้ tail ชี้ตัวก่อนหน้า
                    tail = current.previous;
                    current.previous.next = null;
                }else{ // ถ้าอยุ่ระหว่าง head tail
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                return current;
            }
            current = current.next;
        }
        return new Node("Hero Not Found!");
        
        //END FIX HERE
    }
    
    public void AddNodeAfter(Node node1, Node node2){  // add node2 หลัง node1
        //START FIX HERE
        if(node1.next != null){ //check ว่าอยุ่หลังสุดป่าว
            node1.next.previous = node2;
        }else {
            tail = node2;
        }       
        node2.next = node1.next;
        node1.next = node2;
        node2.previous = node1;
        //END FIX HERE
    }
    
    public void AddNodeBefore(Node node1, Node node2){ // add node2 ก่อน node1
        //START FIX HERE
        if(node1.previous != null){ //check ว่าอยุ่หน้าสุดป่าว
            node1.previous.next = node2;
        }else {
            head = node2;
        }
        node2.previous = node1.previous;
        node1.previous = node2;
        node2.next = node1;
        //END FIX HERE
    }
    
    public boolean IsEmpty(){ // check ว่าว่างมั้ย
        //START FIX HERE
        if(head == null){
            return true;
        }else return false;
        //END FIX HERE
    }
    public void Merge(DoublyLinkedList list){ //รวม list
        //START FIX HERE
        if (list.IsEmpty()) return;
        tail.next = list.head; // เอาหางของตัวแรก ชี้ หัวของlist
        list.head.previous = tail; // เอา previous ของหัวlist2 ชี้ ไปที่หาง
        tail = list.tail; // ท้ายของlist ที่เอามาต่อ กลายเป็นหาง

        //END FIX HERE
    }
    
    public void PrintStructure(){
        //START FIX HERE
        System.out.print(listName + ": head <-> ");
        Node current = head;
        while( current != null){ // print heroid ทุกตัวจาก head2tail
            System.out.print("{" + current.heroId + "} <-> "); 
            current = current.next;
        }
        
        System.out.println("tail");
        //END FIX HERE
    }
    
    // This may be useful for you for implementing printStructure()
    public void PrintStructureTailward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){ // print heroid ทุกตัวจาก tail2head
            System.out.print("{" + current.heroId + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node GetHighestHPHero(){
        //START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        }
        else {
            Node current = head; 
            Node highest = head;
            while(current != null){ // หาค่าสูงสุด loop ไปเรื่อยๆ
                if(current.hp > highest.hp){
                   highest = current; 
                }
                current = current.next;
            }
            return highest;
        }
        //END FIX HERE
    }
    public double GetMiddleHP(){
        //START FIX HERE
        Node current = head;
        int count = 0;
        while(current != null){ // หาจำนวนทั้งหมด ใน list
            count++;
            current = current.next;
        }
        count = count/2;
        current = head;
        for(int i=0 ; i<count ; i++){ //หาค่ากลาง
                current = current.next; 
        }
        if(count%2 == 0){ // ถ้าในลิสเป็นเลขคู่ 
            return (current.hp+current.hp)/2; //หาค่าเฉลี่ยนตรงกลาง
        }else {
            return current.hp; // คืนค่ากลาง
        }
        //END FIX HERE
    }
    public void PrintHeroWithType(Attribute att){
        if (IsEmpty()){
            System.out.println("Empty List!");
            return;
        }
        //START FIX HERE
        Node current = tail;
        int n = 0;
        while(current != null){
            if(current.att == att){
                n++;
            }
            current = current.previous;
        }
        if(n == 0){
            System.out.println("There is no hero with this attribute");
        }else if(n == 1){
            System.out.printf("Print Hero With This Attribute: %s has %d hero\n",att, n);
        }else {
            System.out.printf("Print Hero With This Attribute: %s has %d heroes\n",att, n);
        }
        
        current = head;
        int count = n;
        while(current != null){ //loop print hero แค่ละตัว
            if(current.att == att){ //เช้คว่า attของ hero ปัจจุบัน ตรงกับ  att ที่ต้องการม้ย
                System.out.printf(count + ". HeroID: " + current.heroId +
                                          " , Name: " + current.name + 
                                          " , HP: " + current.hp +
                                          ", Attribute: " + current.att + "\n");
                count--;
            }
            current = current.next;
        }
        //END FIX HERE
    }
}