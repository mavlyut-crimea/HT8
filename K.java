import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

class MyScanner {
    private final BufferedReader in;
    private StringTokenizer stringTokenizer;
 
    public MyScanner(InputStream inputStream) {
        in = new BufferedReader(new InputStreamReader(inputStream));
    }
 
    public String next() throws Exception {
        try {
            return stringTokenizer.nextToken();
        } catch (NoSuchElementException | NullPointerException e) {
            stringTokenizer = new StringTokenizer(in.readLine(), " ");
            return next();
        }
    }
	
	public int nextInt() throws Exception {
		return Integer.parseInt(next());
	}
 
    public void close() throws Exception {
        in.close();
    }
}

public class K {
	public static void main(String[] args) throws Exception {
		new Solution().run();
	}
}

class Solution {
	private final int n;
	private final int m;
	private TreeSet<String> letters = new TreeSet<>();
	private String[] a;
	private MyScanner in = new MyScanner(System.in);
	
	public Solution() throws Exception {
		n = in.nextInt();
		m = in.nextInt();
		a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.next();
			for (int j = 0; j < m; j++) {
				char tmp = a[i].charAt(j);
				if (tmp != '.') {
					letters.add(tmp + "");
				}
			}
		}
	}
	
	public void run() throws Exception {
		in.close();
		for (String string : letters) {
			System.out.println(string);
			giveRect(string.charAt(0));
			for (String i : a) {
				System.out.println(i);
			}
		}
		/*for (String i : a) {
			System.out.println(i);
		}*/
	}
	
	private void giveRect(char x) {
		//точка и x - нули, остальное - единицы. найти макс прямоуг. из 0
		int[] d  = new int[m];
		for (int i = 0; i < m; i++) {
			d[i] = -1;
		}
		int[] d1 = new int[m];
		int[] d2 = new int[m];
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		int e1 = 0, e2 = 0, e3 = 0, e4 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (is1(a[i].charAt(j), x)) {
					d[j] = i;
				}
			}
			while (!st.empty()) {
				st.pop();
			}
			for (int j = 0; j < m; j++) {
				while (!st.empty() && d[st.pop()] <= d[j]) {}
				d1[j] = st.empty() ? -1 : st.peek();
				st.push(j);
			}
			while (!st.empty()) {
				st.pop();
			}
			for (int j = m - 1; j >= 0; j--) {
				while (!st.empty() && d[st.pop()] <= d[j]) {}
				d2[j] = st.empty() ? m : st.peek();
				st.push(j);
			}
			for (int j = 0; j < m; j++) {
				int tmp = (i - d[j]) * (d2[j] - d1[j] - 1);
				if (tmp > ans) {
					ans = tmp;
					e1 = d[j] + 1;
					e2 = i;
					e3 = d1[j] + 1;
					e4 = d2[j] - 1;
				}
			}
			/*for (String qw : a) {
				System.out.println(qw);
			} System.out.println();*/		
		}
		System.out.println(e1 + " " + e2 + " " + e3 + " " + e4 + "\n");
		char w = (char)(x - 'A' + 'a');
		for (int i = e1; i <= e3; i++) {
			for (int j = e2; j <= e4; j++) {
				//if (a[i].charAt(j) != x) {
					StringBuilder q = new StringBuilder(a[i]);
					q.setCharAt(j, w);
					a[i] = q.toString();
				//}
			}
		}
	}
	
	private boolean is1(char x, char y) {
		return x != '.' && y != x;
	}
}