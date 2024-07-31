import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char val;
	Node left;
	Node right;
	
	public Node(char value,Node left,Node right) {
		this.val = value;
		this.left = left;
		this.right = right;
	}
}
public class Main {
	//트리 문제
	static Node tree = new Node('A',null,null); //루트 노드 만들고 시작
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<N; i++) {
			//각각 값 입력받기
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left_char = st.nextToken().charAt(0);
			char right_char = st.nextToken().charAt(0);
			
			insertNode(tree,root,left_char,right_char);
		}
		
		preOrder(tree);
		System.out.println();
		inOrder(tree);
		System.out.println();
		postOrder(tree);
	}
	
	public static void insertNode(Node temp, char root , char left, char right) {
		if(temp.val==root) { //처음 시작일 경우 (루트 노드)
			if(left=='.') {//왼쪽 값이 . 일 경우
				temp.left=null;
			}
			else {
				temp.left = new Node(left,null,null);
			}
			if(right=='.') {//오른쪽 값이 . 일 경우
				temp.right=null;
			}
			else {
				temp.right = new Node(right,null,null);
			}
		} else { //루트 노드가 이미 있는 경우
			if(temp.left !=null) {
				insertNode(temp.left,root,left,right);
			}
			if(temp.right!=null) {
				insertNode(temp.right,root,left,right);
			}
		}
	}
	public static void preOrder(Node temp) {//전위 순회
		if(temp==null) {
			return;
		}
		System.out.print(temp.val);
		preOrder(temp.left);
		preOrder(temp.right);
	}
	public static void inOrder(Node temp) {//중위 순회 
		if(temp==null) {
			return;
		}
		inOrder(temp.left);
		System.out.print(temp.val);
		inOrder(temp.right);
	}
	public static void postOrder(Node temp) {//후위 순회
		if(temp==null){
			return;
		}
		postOrder(temp.left);
		postOrder(temp.right);
		System.out.print(temp.val);
	}
}
