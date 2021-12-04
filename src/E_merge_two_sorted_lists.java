import java.util.List;

public class E_merge_two_sorted_lists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(4);
        list1.next = secondNode;
        secondNode.next = thirdNode;
        ListNode list2 = new ListNode(1);
        ListNode secondNode2 = new ListNode(3);
        ListNode thirdNode2 = new ListNode(4);
        list2.next = secondNode2;
        secondNode2.next = thirdNode2;
        System.out.println(mergeTwoLists(list1, list2));
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode combinedSortedList = new ListNode(0);
        ListNode placeHolderNode = combinedSortedList;
        while (list2 != null && list1 != null) {
            if (list1.val < list2.val) {
                placeHolderNode.next = list1;
                list1 = list1.next;
            } else {
                placeHolderNode.next = list2;
                list2 = list2.next;
            }
            placeHolderNode = placeHolderNode.next;
        }
        if (list1 != null) {
            placeHolderNode.next = list1;
        }
        if (list2 != null) {
            placeHolderNode.next = list2;
        }
        return combinedSortedList.next;
    }
}
