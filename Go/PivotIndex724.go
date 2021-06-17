package Go

func pivotIndex(nums []int) int {
	startSum := 0
	sum := 0
	for _, num := range nums {
		sum += num
	}
	for i, num := range nums {
		if i > 0 {
			startSum += nums[i - 1]
		}
		sum -= num
		if startSum == sum {
			return i
		}
	}
	return -1
}
