class MinStack {
    List<Integer> li;
    private int Minval=Integer.MAX_VALUE;
    private int index;
    Stack<Integer> MinStack;
    public MinStack() {
        li=new ArrayList<>();
        MinStack=new Stack<>();
        index=-1;
    }
    
    public void push(int val) {
        if(MinStack.isEmpty()||val<=MinStack.peek()){
           MinStack.push(val);
        }
        li.add(val);
        index++;
    }
    
    public void pop() {
        if(index==-1){
            return;
        }
        int top=li.remove(index);
        if(top==MinStack.peek()){
            MinStack.pop();
        }
        index--;
    }
    
    public int top() {
        return li.get(index);
    }
    
    public int getMin() {
        return MinStack.peek();
    }
}
