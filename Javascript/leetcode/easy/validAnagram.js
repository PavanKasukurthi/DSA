const isAnagram = function (s, t) {
  if (s.length !== t.length) return false

  let frequencyCounter1 = {}
  let frequencyCounter2 = {}

  s = s.toLowerCase()
  t = t.toLowerCase()

  for (let val of s) {
    frequencyCounter1[val] = (frequencyCounter1[val] || 0) + 1
  }

  for (let val of t) {
    frequencyCounter2[val] = (frequencyCounter2[val] || 0) + 1
  }

  for (let val in frequencyCounter1) {
    if (frequencyCounter1[val] !== frequencyCounter2[val]) return false
  }

  return true
}
