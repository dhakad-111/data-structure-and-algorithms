package com.datastructure.algorithms.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;



public class Dfs {

	private static Map<Integer, List<Integer>> adj = new HashMap<>();

	public static void main(String[] args) {

		try {
			FastReader in = new FastReader();
			FastWriter out = new FastWriter();
			int tt = in.nextInt();
			while (tt-- > 0) {
				int nodes = in.nextInt();
				int edges = in.nextInt();
				Initiatize(nodes);
				for (int i = 0; i < edges; i++) {
					int x = in.nextInt();
					int y = in.nextInt();
					addEdges(x, y);
				}
				printGraph();
				List<Integer> ans = dfs(nodes, 2);
				System.out.println(ans);
			}
			out.close();
		} catch (Exception e) {
			return;
		}

	}

	private static List<Integer> dfs(int nodes, int src) {
		Stack<Integer> st = new Stack<>();
		st.push(src);
		List<Integer> ans = new ArrayList<>();
		boolean visited[] = new boolean[nodes];
		Arrays.fill(visited, false);
		visited[src] = true;
		while (!st.isEmpty()) {
			Integer temp = st.pop();
			ans.add(temp);
			for (Integer i : adj.get(temp)) {
				if (!visited[i]) {
					st.push(i);
					visited[i] = true;
				}
			}
		}
		return ans;
	}

	private static void printGraph() {
		for (Integer x : adj.keySet()) {
			List<Integer> list = adj.get(x);
			System.out.print(x + "->");
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					System.out.print(list.get(i) + "->");
				} else {
					System.out.print(list.get(i));
				}
			}
			System.out.println();
		}
	}

	private static void addEdges(int x, int y) {
		List<Integer> list = adj.get(x);
		list.add(y);
		adj.put(x, list);
	}

	private static void Initiatize(int nodes) {
		for (int i = 0; i < nodes; i++) {
			adj.putIfAbsent(i, new ArrayList<>());
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine().trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static class FastWriter {
		private final BufferedWriter bw;

		public FastWriter() {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		public void print(Object obj) throws IOException {
			bw.append("" + obj);
		}

		public void println(Object obj) throws IOException {
			print(obj);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}

}
