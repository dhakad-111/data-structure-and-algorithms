package com.datastructure.algorithms.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Graph {

	private int nodes;
	private int edges;
	private static Map<Integer, List<Integer>> grid = new HashMap<>();

	public Graph(int nodes, int edges) {
		this.nodes = nodes;
		this.edges = edges;
		for (int i = 0; i < nodes; i++) {
			grid.putIfAbsent(i, new ArrayList<>());
		}
	}

	public static void addEdges(int x, int y) {
		List<Integer> list = grid.get(x);
		list.add(y);
		grid.put(x, list);
	}

	public static void main(String[] args) {
		try {
			FastReader in = new FastReader();
			FastWriter out = new FastWriter();
			int tt = in.nextInt();
			while (tt-- > 0) {
				int nodes = in.nextInt();
				int edges = in.nextInt();
				Graph graph = new Graph(nodes, edges);
				for (int i = 0; i < edges; i++) {
					int x = in.nextInt();
					int y = in.nextInt();
					addEdges(x, y);
				}
				printGraph();

			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printGraph() {

		for (Integer x : grid.keySet()) {
			List<Integer> list = grid.get(x);
			System.out.print(x + "->");
			for(int i = 0; i < list.size(); i++) {
				if(i < list.size()-1) {
					System.out.print(list.get(i)+"->");
				}else {
					System.out.print(list.get(i));
				}
			}
			System.out.println();
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

		public void print(Object object) throws IOException {
			bw.append("" + object);
		}

		public void println(Object object) throws IOException {
			print(object);
			bw.append("\n");
		}

		public void close() throws IOException {
			bw.close();
		}
	}

}
