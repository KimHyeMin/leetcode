package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class 양과늑대 {
    public int solution(int[] info, int[][] edges) {
        int[][] path = new int[info.length][info.length];

        Sheep[] stored = new Sheep[info.length];

        for (int[] edge : edges) {
            int from =edge[0], to = edge[1];
            path[from][to] = 1; //순
            path[to][from] = 1; //역
        }

        Queue<Sheep> queue = new ArrayDeque<>();

        boolean[][] flag = new boolean[info.length][info.length];
        queue.add(new Sheep(0, 1, 0, flag));
        stored[0] = new Sheep(0, 1, 0);


        while (!queue.isEmpty()) {
            Sheep head = queue.poll();
            System.out.println("#:"+head.node + " : " + head.sheepCnt);
            if (stored[head.node] == null) {
                stored[head.node] = head;
            } else {
                stored[head.node] = head.compareTo(stored[head.node]) > 0 ? head : stored[head.node];
            }


            if (head.wolfCnt >= head.sheepCnt) {
                continue;
            }

            for (int i =0 ;i<path[head.node].length;i++) {
                //길이 있다.
                if (path[head.node][i] == 1) {
                    if (head.flag[head.node][i]) {  // 이미 왔다 갔는지?
                        if (head.compareTo(stored[i]) >= 1)
                            queue.add(new Sheep(i, head.sheepCnt, head.wolfCnt, head.flag.clone()));
                    } else {
                        // 처음 온 길이야?
                        boolean[][] arr = deepCopy(head.flag);
                        arr[head.node][i] = true;
                        arr[i][head.node] = true;

                        if (info[i] == 0) {
                            queue.add(new Sheep(i, head.sheepCnt + 1, head.wolfCnt, arr));
                        } else {
                            if (head.wolfCnt + 1 < head.sheepCnt) {
                                queue.add(new Sheep(i, head.sheepCnt, head.wolfCnt + 1, arr));
                            }
                        }
                    }
                }
            }
        }

        return stored[0].sheepCnt;
    }

    private boolean[][] deepCopy(boolean[][] flag) {
        boolean[][] newFlag = new boolean[flag.length][flag[0].length];
        for (int i = 0 ;i<flag.length;i++) {
            System.arraycopy(flag[i], 0, newFlag[i], 0, flag[i].length);
        }
        return newFlag;
    }


    public static class Sheep implements Comparable<Sheep> {
        int node;
        int sheepCnt;
        int wolfCnt;
        boolean[][] flag;

        public Sheep(int nodeNum, int sheepCnt, int wolfCnt, boolean[][] flag) {
            this.node = nodeNum;
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
            this.flag = flag;
        }
        public Sheep(int nodeNum, int sheepCnt, int wolfCnt) {
            this.node = nodeNum;
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
        }

        @Override
        public int compareTo(Sheep o) {

            if (this.sheepCnt > o.sheepCnt) {
                return 1;
            } else if (this.sheepCnt < o.sheepCnt) {
                return -1;
            } else {
                if (this.wolfCnt < o.wolfCnt) {
                    return 1;
                } else if(this.wolfCnt > o.wolfCnt) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

    }
}
