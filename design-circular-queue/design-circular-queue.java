class MyCircularQueue {

    int front, rear, arr[];
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        else if(isEmpty()) {
            front = 0;
            rear = 0;
            arr[rear] = value;
            return true;
        }
        else {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
            return true;
        }
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        else if(front == rear) {
            front = -1;
            rear = -1;
            return true;
        }
        else {
            front = (front + 1) % arr.length;
            return true;
        }
    }
    
    public int Front() {
        if(!isEmpty())
            return arr[front];
        
        return -1;
    }
    
    public int Rear() {
        if(!isEmpty())
            return arr[rear];
        
        return -1;
    }
    
    public boolean isEmpty() {
        if(front == -1) 
            return true;
        
        return false;
    }
    
    public boolean isFull() {
        if((front == 0 && rear == arr.length-1) || (front == rear + 1)) {
            return true;
        }
        
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */