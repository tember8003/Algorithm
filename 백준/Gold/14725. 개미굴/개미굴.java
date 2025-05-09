import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Tree{
		HashMap<String, Tree> tree;
		
		Tree(){
			tree = new HashMap<>();
		}
	}
	
	static Tree root = new Tree();
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			Tree cur = root;
			
			for(int j=0; j<num; j++) {
				String str = st.nextToken();
				if(!cur.tree.containsKey(str)) {
					cur.tree.put(str, new Tree());
				}
				cur = cur.tree.get(str);
			}
		}
		
		printTree(root,"");
		System.out.println(sb.toString());
		
	}
	public static void printTree(Tree cur, String str) {
		ArrayList<String> list = new ArrayList<>(cur.tree.keySet());
		Collections.sort(list);
		
		for(String tree_str : list) {
			sb.append(str).append(tree_str).append("\n");
			printTree(cur.tree.get(tree_str),str+"--");
		}
	}
}
