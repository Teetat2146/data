public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        //START FIX HERE
        listName = name;
        //END FIX HERE
    }
    
    public void PopTail() {
        //START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
        }else {
            if(tail == head){
                head = null;
                tail = null;
            }else{
                tail = tail.previous;
                tail.next = null;   
            }
            
        }
        //END FIX HERE
    }
    
    public void PopHead(){
        //START FIX HERE
        if (IsEmpty()) {
            System.out.println("ERROR");
        }else {
            head = head.next;
            head.previous = null;
        }
        //END FIX HERE
    }
    
    public Node GetHead(){
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
    
    public Node GetTail(){
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
    
    public void PushHead(Node node){
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
    
    public void PushTail(Node node) {
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

    public Node FindNode(int id){
        //START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        }
        else {
            Node current = head;
            while(current != null){
                if(current.heroId == id){
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
        while(current != null){
            if(current.heroId == id){
                if(current == head){
                    head = current.next;
                    current.next.previous = null;
                }else if(current == tail){
                    tail = current.previous;
                    current.previous.next = null;
                }else{
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
    
    public void AddNodeAfter(Node node1, Node node2){
        //START FIX HERE
        if(node1.next != null){
            node1.next.previous = node2;
        }else {
            tail = node2;
        }       
        node2.next = node1.next;
        node1.next = node2;
        node2.previous = node1;
        //END FIX HERE
    }
    
    public void AddNodeBefore(Node node1, Node node2){
        //START FIX HERE
        if(node1.previous != null){
            node1.previous.next = node2;
        }else {
            head = node2;
        }
        node2.previous = node1.previous;
        node1.previous = node2;
        node2.next = node1;
        //END FIX HERE
    }
    
    public boolean IsEmpty(){
        //START FIX HERE
        if(head == null){
            return true;
        }else return false;
        //END FIX HERE
    }
    public void Merge(DoublyLinkedList list){
        //START FIX HERE
        if (list.IsEmpty()) return;
        tail.next = list.head;
        list.head.previous = tail;
        tail = list.tail;

        //END FIX HERE
    }
    
    public void PrintStructure(){
        //START FIX HERE
        System.out.print(listName + ": head <-> ");
        Node current = head;
        while( current != null){
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
        while(current!=null){
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
            while(current != null){
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
        while(current != null){
            count++;
            current = current.next;
        }
        count = count/2;
        current = head;
        for(int i=0 ; i<count ; i++){
            current = current.next;
        }
        return current.hp;
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
        while(current != null){
            if(current.att == att){
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