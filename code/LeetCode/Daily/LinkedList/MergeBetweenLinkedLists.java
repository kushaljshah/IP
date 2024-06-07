package LeetCode.Daily.LinkedList;

import LeetCode.Daily.LinkedList.ListNode;

/**
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 * The blue edges and nodes in the following figure indicate the result:
 *
 *
 * Build the result list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * Output: [10,1,13,1000000,1000001,1000002,5]
 * Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
 * Example 2:
 *
 *
 * Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 * Explanation: The blue edges and nodes in the above figure indicate the result.
 */

public class MergeBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int counter = 0;
        ListNode tmp = null;
        ListNode print1 = list1;
        ListNode head = list1;
        while (print1 != null){
            System.out.println(print1.val);
            print1 = print1.next;
        }


        while (list1 != null && list1.next != null){
            if(list1 != null && counter == a - 1) {
                tmp = list1.next;
                list1.next = list2;
                break;
            }
            counter++;
            list1 = list1.next;
        }

        ListNode print2 = list1;
        while (print2 != null){
            System.out.println(print2.val);
            print2 = print2.next;
        }

        ListNode destination = null;
        while (tmp != null && tmp.next != null){
            if(tmp != null && counter == b - 1){
                destination = tmp.next;
                break;
            }
            counter++;
            tmp = tmp.next;

        }



        while (list1 != null && list1.next != null){
            list1 = list1.next;
        }

        list1.next = destination;

        return list1;

    }



}
