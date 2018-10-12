//Implementing Queue using Stacks
class MyQueue {
    Stack<Integer> s;
    Stack<Integer> tmp;
    public MyQueue() {
        s = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(!s.isEmpty()){
            while(!s.isEmpty())
                tmp.push(s.pop());
            tmp.push(x);
            while(!tmp.isEmpty())
                s.push(tmp.pop());
        }else {
            while(!tmp.isEmpty())
                s.push(tmp.pop());
            s.push(x);
            while(!s.isEmpty())
                tmp.push(s.pop());
        }
    }
    
    public int pop() {
        if(!s.isEmpty())
            return s.pop();
        else
            return tmp.pop();
    }
    
    public int peek() {
        if(!s.isEmpty())
            return s.peek();
        else
            return tmp.peek();
    }
    
    public boolean empty() {
        if(s.isEmpty() && tmp.isEmpty())
            return true;
        else
            return false;
    }
}
