import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.StringTokenizer;

class Node{
    int num;
    int parent;
    int left;
    int right;

    Node(int num,int left,int right){
        this.num = num;
        this.parent = -1;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Node[] tree;
    static int[] min, max;
    static int nodeIdx=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];
        int root = 0;
        min = new int[N+1];
        max = new int[N+1];

        for(int i=0; i<=N; i++){
            tree[i] = new Node(i, -1, -1);
            min[i] = N;
            max[i] = 0;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[num].left = left;
            tree[num].right = right;

            if(left != -1)
                tree[left].parent = num;
            if(right != -1)
                tree[right].parent = num;
        }

        for(int i=1; i<=N; i++){
            if(tree[i].parent == -1){
                root = i;
                break;
            }
        }

        inOrder(root, 1);
        int level = 1;
        int width = 0;

        for(int i=1; i<=N; i++){
            int temp = max[i]-min[i];
            if(width < temp){
                level = i;
                width = temp;
            }
        }
        System.out.println(level + " " + (width+1));
    }

    public static void inOrder(int root, int level){
        Node cur = tree[root];

        if(cur.left != -1)
            inOrder(cur.left, level+1);

        min[level] = Math.min(min[level], nodeIdx);
        max[level] = Math.max(max[level], nodeIdx);
        nodeIdx++;

        if(cur.right != -1){
            inOrder(cur.right, level+1);
        }
    }
}