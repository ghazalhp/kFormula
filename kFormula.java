import java.util.ArrayList;
import java.util.Scanner;

public class kFormula {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), e = in.nextInt();
		int[][] g = new int[n][n];
		for (int k = 0; k < e; k++) {
			int i = in.nextInt(), j = in.nextInt();
			g[i][j] = 1;
		}
		ArrayList<Integer> a[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
			a[i].add(i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] > 0) {
					a[i].add(0, -3);
					a[i].add(j);
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.addAll(a[0]);
		a[0].clear();
		a[0] = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < ans.size(); j++) {
				if (ans.get(j) > 0 && a[ans.get(j)] != null) {
					System.out.println("LLL" + ans.size() + " "
							+ a[ans.get(j)].size() + " " + ans.get(j));
					int em = ans.get(j);
					ans.remove(j);

					for (int k = 0; k < a[em].size(); k++)
						ans.add(j + k, a[em].get(k));
					a[em] = null;
					break;
				}
			}
		}
		for (int i = 0; i < ans.size(); i++) {
			if (ans.get(i) >= 0)
				System.out.print(ans.get(i) + " ");
			else
				System.out.print("*");
		}
		System.out.println("");
	}
}
