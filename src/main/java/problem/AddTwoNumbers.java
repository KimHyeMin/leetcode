package problem;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = new ListNode(0),latest = null;
        ListNode p = l1, q = l2;
        int carry = 0;

        while(true) {
            int a = carry + getAnInt(p) + getAnInt(q);

            carry = a/10;
            ListNode b = new ListNode(a % 10);

            if (latest != null) {
                latest.next = b;
            } else {
                first = b;
            }
            latest=b;
            p = getNextP(p);
            q = getNextP(q);

            if (p==null && q==null) {
                break;
            }
        }

        if (carry > 0) {
            latest.next = new ListNode(carry);
        }
        return first;
        //return writeToNode(readFromListNode(l1) + readFromListNode(l2));
    }

    private ListNode getNextP(ListNode p) {
        return p==null?null:p.next;
    }

    private int getAnInt(ListNode p) {
        return p == null? 0 : p.val;
    }

    /**
     * (2 -> 4 -> 3) = 342
     * @param listNode
     * @return
     */
    long readFromListNode(ListNode listNode) {

        long res = 0;
        int ss = 1;
        ListNode worker = listNode;

        while(true) {
            int val = worker.val;
            res = res + val*ss;
            ss = ss*10;
            worker = worker.next;
            if (worker == null) {
                break;
            }
        }
        return res;
    }

    ListNode writeToNode(long num) {
        ListNode first = null;
        ListNode latest = null;

        long w = num;
        while(true) {
            ListNode b = new ListNode((int) (w % 10));

            if (latest != null) {
                latest.next =b;
            } else {
                first = b;
            }

            latest = b;
            w = w / 10;
            if (w == 0) {
                break;
            }
        }

        return first;
    }

}
