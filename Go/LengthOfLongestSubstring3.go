package Go

func lengthOfLongestSubstring(s string) int {
	res := 0
	kv := make(map[rune]int, 0)
	//for range --- rune; for i...--- byte
	start := -1
	for i, ch := range s {
		if kv[ch] != 0 {
			start = max(start, kv[ch]-1)
		}
		res = max(res, i-start)
		kv[ch] = i + 1
	}
	return res
}
