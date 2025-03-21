/**
 * GFG Question link :
 * https://takeuforward.org/data-structure/implement-stack-using-array/
 */
class StackUsingArray {
    int size;
    int top;
    int capacity;
    int[] s;

    StackUsingArray(int cap) {
        this.capacity = cap;
        this.size = 0;
        this.s = new int[cap];
        this.top = -1;
    }

    void push(int x) {
        this.s[++top] = x;
        this.size++;
    }

    int pop() {
        if (top == -1)
            return -1;
        int top = this.s[this.top];
        this.size--;
        this.top--;
        return top;
    }

    int peek() {
        if (top == -1)
            return -1;
        return this.s[top];
    }
}