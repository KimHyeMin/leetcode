package problem;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddTwoNumbersTest {

    AddTwoNumbers dut = new AddTwoNumbers();

    @Test public void 합친다() throws Exception {

        ListNode res = dut.addTwoNumbers(make("2 -> 4 -> 3"), make("5 -> 6 -> 4"));

        assertThat(res.val, is(7));
        assertThat(res.next.val, is(0));
        assertThat(res.next.next.val, is(8));
    }
    @Test public void 합친다2() throws Exception {

        ListNode res = dut.addTwoNumbers(make("9"), make("1->9->9->9->9->9->9->9->9->9"));

        System.out.print(dut.readFromListNode(res));
    }

    @Test
    public void 읽는다() throws Exception {
        ListNode a = make("2 -> 4 -> 3");
        long res = dut.readFromListNode(a);

        assertThat(res, is(342));
    }

    @Test
    public void 읽는다2() throws Exception {
        ListNode a = make("0");
        long res = dut.readFromListNode(a);

        assertThat(res, is(0));
    }

    @Test
    public void 쓴다() throws Exception {
        ListNode res = dut.writeToNode(342);

        assertThat(res.val, is(2));
        assertThat(res.next.val, is(4));
        assertThat(res.next.next.val, is(3));
    }
    @Test
    public void 쓴다2() throws Exception {
        ListNode res = dut.writeToNode(0);

        assertThat(res.val, is(0));

    }

    @Test
    public void ddd() throws Exception {
        ListNode res = make("2 -> 4 -> 3");

        assertThat(res.val, is(2));
        assertThat(res.next.val, is(4));
        assertThat(res.next.next.val, is(3));
    }

    private ListNode make(String s) {
        char[] chars = s.toCharArray();
        ListNode pointer = null;
        for (int i = chars.length-1 ; i>=0; i--) {
            if (chars[i] >= 48 && chars[i] < 58) {
                ListNode a = new ListNode(chars[i]-48);
                a.next=pointer;
                pointer = a;
            }
        }
        return pointer;
    }

}