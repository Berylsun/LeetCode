package main

import "fmt"

func BubbleSort(nums [8]int) [8]int {
	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums) - i- 1; j++ {
			if nums[j] > nums[j + 1] {
				nums[j], nums[j + 1] = nums[j + 1], nums[j]
			}
		}
	}
	return nums
}


func main()  {
	nums := [8]int{8,3,2,9,4,6,10,0}
	fmt.Println(BubbleSort(nums))
}