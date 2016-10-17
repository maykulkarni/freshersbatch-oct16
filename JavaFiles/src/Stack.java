import java.util.Arrays;

public class Stack {
    int[] arr;
    int head;

    Stack(int size) {
        arr = new int[size];
        head = -1;
    }

    public void push(int data) {
        arr[++head] = data;
    }

    public int pop() {
        int ans = arr[head];
        head--;
        return ans;
    }

    public static void main(String[] args) {
        Stack st = new Stack(4);
        st.push(3);
        st.push(1);
        System.out.println(Arrays.toString(st.arr));
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}