package main

import "fmt"

func SelectSort(nums [8]int) [8]int {
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[j] < nums[i] {
				nums[i], nums[j] = nums[j], nums[i]
			}
		}
	}
	return nums
}


func main()  {
	nums := [8]int{8,3,2,9,4,6,10,0}
	fmt.Println(SelectSort(nums))
}