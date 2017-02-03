import java.util.ArrayList;
import java.util.Scanner;

public class kFormulaOnvari {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		String s = in.nextLine();
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*')
				ans.add(-3);
			else if (s.charAt(i) == ' ')
				continue;
			else {
				ans.add(s.charAt(i) - '0');
				if (s.charAt(i) - '0' > n)
					n = s.charAt(i) - '0';
			}
		}
		n++;
		int[][] g = new int[n][n];
		int t = 0;
		System.out.println("size" + ans.size());

		while (ans.size() > 1) {
			for (int i = 0; i < ans.size(); i++) {
				if (ans.get(i) == -3) {
					t++;
				} else {
					boolean is = false;
					for (int j = i; j < i + t + 1; j++)
						if (ans.get(j) == -3)
							is = true;
					if (!is) {
						for (int j = i + 1; j < i + t + 1; j++)
							g[ans.get(i)][ans.get(j)] = 1;
						for (int j = i + 1; j < i + t + 1; j++)
							ans.remove(i + 1);
						for(int j =0 ; j< t ; j++)
							ans.remove(i-t);
						

					}
					t = 0;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(g[i][j]);
			System.out.println("");
		}

	}
}
