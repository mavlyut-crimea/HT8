package HT8;

public class A {
    public static void main(String[] args) throws Exception {
        MyScanner in = new MyScanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        System.out.println(2 * (int)((long)(n - a - 1) / (b - a)) + 1);
    }
}