package main

import "fmt"

func InsertSort(nums [8]int) [8]int {
	for i := 1; i < len(nums); i++ {
		for j := i; j > 0; j-- {
			if nums[j] < nums[j - 1] {
				nums[j], nums[j - 1] = nums[j - 1], nums[j]
			} else {
				break
			}
		}
	}
	return nums
}


func main()  {
	nums := [8]int{8,3,2,9,4,6,10,0}
	fmt.Println(InsertSort(nums))
}