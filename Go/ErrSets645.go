package Go

import "sort"

func findErrorNums1(nums []int) []int {
	res := make([]int, 2, 2)
	for i := 0; i < len(nums); i++ {
		v := nums[i]
		if v != i + 1 {
			if nums[v - 1] == v {
				res[0] = v
			} else {
				nums[v - 1], nums[i] = v, nums[v - 1]
				i--
			}
		}
	}

	for i,v := range nums {
		if v != i + 1 {
			res[1] = i + 1
		}
	}
	return res
}

// sort
func findErrorNums2(nums []int) []int {
	ans := make([]int, 2)
	sort.Ints(nums)
	pre := 0
	for _, v := range nums {
		if v == pre {
			ans[0] = v
		} else if v-pre > 1 {
			ans[1] = pre + 1
		}
		pre = v
	}
	n := len(nums)
	if nums[n-1] != n {
		ans[1] = n
	}
	return ans
}


// bit   lowbit = xor & (−xor)，则 lowbit 为 x 和 y 的二进制表示中的最低不同位
func findErrorNums3(nums []int) []int {
	xor := 0
	for _, v := range nums {
		xor ^= v
	}
	n := len(nums)
	for i := 1; i <= n; i++ {
		xor ^= i
	}
	lowbit := xor & -xor
	num1, num2 := 0, 0
	for _, v := range nums {
		if v&lowbit == 0 {
			num1 ^= v
		} else {
			num2 ^= v
		}
	}
	for i := 1; i <= n; i++ {
		if i&lowbit == 0 {
			num1 ^= i
		} else {
			num2 ^= i
		}
	}
	for _, v := range nums {
		if v == num1 {
			return []int{num1, num2}
		}
	}
	return []int{num2, num1}
}

// smart
func findErrorNums4(nums []int) []int {
	res := make([]int, 2)
	for _,v := range nums {
		idx := abs(v)
		if nums[idx - 1] < 0 {
			res[0] = idx
		} else {
			nums[idx - 1] *= -1
		}
	}

	for i,v := range nums {
		if v > 0 {
			res[1] = i + 1
		}
	}
	return res;
}

func abs(a int) int{
	if a < 0 {
		return -a
	}
	return a
}