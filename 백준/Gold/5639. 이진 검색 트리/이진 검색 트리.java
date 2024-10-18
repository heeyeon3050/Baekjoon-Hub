import java.io.*;

public class Main {

	private static class Node {
		int num;
		Node left, right;

		public Node(int num) {
			this.num = num;
		}

		void insert(int input) {
			// 삽입 노드가 현재 노드보다 작을 때(왼쪽 삽입)
			if (this.num > input) {
				if(this.left == null) {
					this.left = new Node(input);
				}else{
					this.left.insert(input);
				}
			}
			// 삽입 노드가 현재 노드보다 클 때(오른쪽 삽입)
			else{
				if(this.right == null){
					this.right = new Node(input);
				}else {
					this.right.insert(input);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 루트 노드
		Node node = new Node(Integer.parseInt(br.readLine()));

		// 하위 노드
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals(""))
				break;

			int input = Integer.parseInt(str);
			node.insert(input);
		}

		postOrder(node);
	}

	static void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
}