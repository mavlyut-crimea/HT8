package HT8;

import java.util.Arrays;

class IntList {
    private int[] a;
    private int size;

    public IntList() {
        a = new int[1];
        size = 1;
    }

    public void push(int x) {
        if (a.length == size) {
            a = Arrays.copyOf(a, size * 2);
        }
        a[size++] = x;
    }

    public int get(int i) {
        return a[i];
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        int[] answer = Arrays.copyOf(a, size);
        for (int i : answer) {
            ans.append(i).append(" ");
        }
        return ans.toString();
    }
}
