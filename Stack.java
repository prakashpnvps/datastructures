//Implementing Stack using Queues
class MyStack {
    Queue<Integer> q;
    Queue<Integer> tmp;
    public MyStack() {
        q = new LinkedList<>();
        tmp = new LinkedList<>();
    }
    
    public void push(int x) {
        if(q.isEmpty()){
            q.offer(x);
            while(!tmp.isEmpty())
                q.offer(tmp.poll());
        }
        else{
            tmp.offer(x);
            while(!q.isEmpty())
                tmp.offer(q.poll());
        }
    }
    
    public int pop() {
        if(!q.isEmpty())
            return q.poll();
        else
            return tmp.poll();
    }
    
    public int top() {
        if(!q.isEmpty())
            return q.peek();
        else
            return tmp.peek();
    }
    
    public boolean empty() {
        if(q.isEmpty() && tmp.isEmpty())
            return true;
        else
            return false;
    }
}
