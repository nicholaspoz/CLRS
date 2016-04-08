package clrs.algorithms.dynamicprogramming;

public class MatrixChain {

	private static class Solution {
		public final int[][] m;
		public final int[][] s;

		public Solution(int[][] m, int[][] s) {
			this.m = m;
			this.s = s;
		}
	}

	public static Solution matrixChainOrder(int[] p) {
		int n = p.length - 1;

		// soln[i][j] contians k s.t i <= k < j AND (A_i,k) * (A_k+1,j) is
		// optimal
		int[][] soln = new int[n][n];
		// m[i][j] contains the optimal # of mults to calculate A_i*...*A_j
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			m[i][i] = 0;
		}

		for (int l = 2; l <= n; l++) {// l is the chain length
			// Solve subproblems A_i...A_(i+l)
			for (int i = 0; i <= n - l; i++) {
				// i is the beginning of the interval l
				// j is the end of the interval l
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i][k] + m[k + 1][j] + (p[i] * p[k + 1] * p[j + 1]);
					if (q < m[i][j]) {
						m[i][j] = q;
						soln[i][j] = k;
					}
				}
			}
		}

		return new Solution(m, soln);
	}

	public static void buildOptimalParensString(int i, int j, int[][] s, StringBuilder stringBuilder) {
		if (i == j) {
			stringBuilder.append(" A" + i + " ");
		} else {
			stringBuilder.append("(");
			buildOptimalParensString(i, s[i][j], s, stringBuilder);
			buildOptimalParensString(s[i][j] + 1, j, s, stringBuilder);
			stringBuilder.append(")");
		}
	}

	public static void main(String[] args) {
		int[] p = { 30, 35, 15, 5, 10, 20, 25 };
		StringBuilder builder = new StringBuilder();

		Solution soln = matrixChainOrder(p);
		buildOptimalParensString(0, p.length - 2, soln.s, builder);

		System.out.println(soln.m[0][p.length - 2] + ", " + builder.toString());

	}

}
