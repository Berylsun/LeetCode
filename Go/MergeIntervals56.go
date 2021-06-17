package Go

import "sort"

//O(mn) O(mn)
func merge(intervals [][]int) [][]int {
	if intervals == nil || len(intervals) == 0 || intervals[0] == nil || len(intervals[0]) == 0 {
		return intervals
	}
	sort.Slice(intervals, func (i, j int) bool{
		return intervals[i][0] < intervals[j][0]
	})

	start := intervals[0][0]
	end := intervals[0][1]
	idx := 1
	var res [][]int
	for idx < len(intervals) {
		interval := intervals[idx]
		if interval[0] <= end {
			end = max(interval[1], end)
		} else if interval[0] > end {
			res = append(res, []int{start, end})
			start = interval[0]
			end = interval[1]
		}
		idx++
	}
	res = append(res, []int{start, end})
	return res
}

func max(x, y int) int{
	if x > y {
		return x
	}
	return y
}
