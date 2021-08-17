package Go

func checkRecord(s string) bool {
	a := 0
	b := 0
	for _, ch := range s {
		if ch == 'A' {
			a++
			if a == 2 {
				return false
			}
		}
		if ch == 'L' {
			b++
			if b == 3 {
				return false
			}
		} else {
			b = 0
		}
	}
	return true
}
