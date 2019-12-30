package cn.andios;

/**
 * @Author: lsd
 * @Description: 206
 * @Date: 2019/12/21 涓婂崍9:38
 */
public class  Test206 {
    /**
     * 鏂规硶浜�
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    /**
     * 鏂规硶涓�
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if(head== null) {
        	return null;
        }
        /**
         * 3涓寚閽坧re,cur,next,姣斿閾捐〃涓� a->b->c->d->e->f,鍒欏紑濮嬫椂鍒嗗埆鎸囧悜null,a,b
         * 绗竴姝ワ細鍥犱负瑕佸弽杞�,鍗崇澶村弽鍚�,鎵�浠->b鍙樹负a->null,鍗砪ur.next = pre;
         *      姝ゆ椂閾捐〃鍙樹负 null<-a b->c->d->e->f, pre,cur,next鍒嗗埆鎸囧悜null,a,b
         * 绗簩姝ワ細pre,cur,next鍒嗗埆鍚庣Щ涓�浣�,pre鎸囧悜null鍙樹负p鎸囧悜a,cur鎸囧悜a鍙樹负cur鎸囧悜b,
         *      娉ㄦ剰,cur锛�=null鎵嶄細杩涘叆寰幆,鑰宯ext鎸囧悜cur鐨勫悗涓�浣�,姝ゆ椂cur寰�鍚庣Щ浜嗕竴浣�,
         *      浣唍ext涓嶈兘寰�鍚庣Щ,鍥犱负next姝ゆ椂鍙兘宸茬粡鎸囧悜null,濡傛灉next鍚庣Щ,鍙兘鍙戠敓绌烘寚閽堬紝
         *      蹇呴』鍦ㄤ笅涓�娆″惊鐜椂鎵嶈兘鍚庣Щnext
         * 寰幆绗簩姝�,涓�鐩村埌cur鎸囧悜null,姝ゆ椂pre鎸囧悜鏈�鍚庝竴浣峟,鎵�浠ユ渶缁堣繑鍥瀙re
         *
         */
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;

            cur.next = pre;
        	pre = cur;
        	cur = next;
        }
        return pre;
    }
    
    public static void main(String []args) {

        //灏炬彃娉曠敓鎴愰摼琛�
        ListNode head = new ListNode(0);
        ListNode tail = null;
        tail = head;
        ListNode newNode = null;
        for (int i = 10; i < 15; i++) {
    		newNode = new ListNode(i);
    		tail.next = newNode;
		    tail = newNode;
    	}

        //0	10	11	12	13	14
//        while(head != null) {
//            System.out.print(head.val+"\t");
//            head = head.next;
//        }

//      14	13	12	11	10	0
    	ListNode reverseList = reverseList1(head);
    	//ListNode reverseList = reverseList2(head);
        //鎵撳嵃鍙嶈浆鍚庣殑缁撴灉
    	while(reverseList != null) {
            System.out.print(reverseList.val+"\t");
            reverseList = reverseList.next;
    	}
    }
}

/**
 * 鑺傜偣绫�
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}