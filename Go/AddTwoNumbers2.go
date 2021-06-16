package Go

/*
	cur.Next = &ListNode{Val: add}
	return cur.Next //[] == nil

	return &ListNode{} //[0]
*/




//Definition for singly-linked list.
type ListNode struct {
    Val int
    Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	add := 0
	res := &ListNode{}
	cur := res
	for l1 != nil || l2 != nil || add != 0{
		if l1 != nil {
			add += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			add += l2.Val
			l2 = l2.Next
		}
		val := add % 10
		add = add / 10
		cur.Val = val
		if l1 == nil && l2 == nil && add == 0 {
			break
		}
		cur.Next = &ListNode{}
		cur = cur.Next
	}
	return res
}


func addTwoNumbers2(l1 *ListNode, l2 *ListNode) *ListNode {
	add := 0
	res := &ListNode{}
	cur := res
	for l1 != nil || l2 != nil {
		if l1 != nil {
			add += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			add += l2.Val
			l2 = l2.Next
		}
		val := add % 10
		add = add / 10
		cur.Next = &ListNode{Val:val}
		cur = cur.Next
	}
	if add != 0 {
		cur.Next = &ListNode{Val: add}
	}
	return res.Next
}
