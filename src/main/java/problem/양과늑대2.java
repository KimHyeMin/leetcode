package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class 양과늑대2 {
    public int solution(int[] info, int[][] edges) {
        int[][] path = new int[info.length][info.length];

        for (int[] edge : edges) {
            int from =edge[0], to = edge[1];
            path[from][to] = 1; path[to][from] = 1;
        }

        Node[] flag = new Node[info.length];
        flag[0] = new Node(1, 0);
        Queue<Sheep> queue = new ArrayDeque<>();
        Sheep first = new Sheep(0, 1, 0, flag);
        queue.add(first);

        int answer = 0;
        while (!queue.isEmpty()) {
            Sheep head = queue.poll();
            Node currentN = new Node(head.sheepCnt, head.wolfCnt);

            if (head.wolfCnt >= head.sheepCnt) {
                continue;
            }

            if (head.node == 0 && answer < head.sheepCnt) {
                answer = head.sheepCnt;
            }

            for (int i = 0; i < path[head.node].length; i++) {
                //길이 있다.
                if (path[head.node][i] == 1) {

                    if (head.flag[i] == null) {
                        int sheepCnt = head.sheepCnt + (info[i] == 0 ? 1 : 0);
                        int wolfCnt = head.wolfCnt + (info[i] == 1 ? 1 : 0);

                        if (sheepCnt > wolfCnt) {
                            Node[] arr = deepCopy(head.flag);
                            arr[i] = new Node(sheepCnt, wolfCnt);
                            queue.add(new Sheep(i, sheepCnt, wolfCnt, arr));
                        }
                    } else {
                        if (currentN.compareTo(head.flag[i]) > 0) {
                            head.flag[i] = currentN;
                            queue.add(new Sheep(i, currentN.sheepCnt, currentN.wolfCnt, head.flag));
                        }

                    }
                }
            }
        }

        return answer;
    }

    private Node[] deepCopy(Node[] flag) {
        Node[] newFlag = new Node[flag.length];
        System.arraycopy(flag, 0, newFlag, 0, flag.length);
        return newFlag;
    }

    public static class Node implements Comparable<Node> {
        int sheepCnt;
        int wolfCnt;

        public Node(int sheepCnt, int wolfCnt) {
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
        }
        @Override
        public int compareTo(Node o) {
            if (this.sheepCnt == o.sheepCnt) {
                if (this.wolfCnt < o.wolfCnt) {
                    return 1;
                } else if(this.wolfCnt > o.wolfCnt) {
                    return -1;
                } else {
                    return 0;
                }
            }
            return this.sheepCnt > o.sheepCnt ? 1 : -1;
        }
    }
    public static class Sheep {
        int node;
        int sheepCnt;
        int wolfCnt;
        Node[] flag;

        public Sheep(int nodeNum, int sheepCnt, int wolfCnt, Node[] flag) {
            this.node = nodeNum;
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
            this.flag = flag;
        }

    }
}
