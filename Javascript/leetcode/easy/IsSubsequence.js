const IsSubsequence = (s, t) => {
  if (s.length === 0) return true

  let i = 0,
    j = 0
  while (i < s.length && j < t.length) {
    if (s[i] === t[j]) {
      i++
    }
    j++
  }

  if (i === s.length) return true

  return false
}

console.log(IsSubsequence('aaaaaa', 'bbaaaa'))
