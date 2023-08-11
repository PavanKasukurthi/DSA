//Write a function called averagePair. Given a sorted array of integers and a target average,
// determine if there is a pair of values in the array where the average of the pair equals the target avg.
//There may be more than one pair that matches the average target

const averagePair = (arr, avg) => {
  let start = 0
  let end = arr.length - 1

  if (arr.length === 0) return false

  while (start <= end) {
    let calc = (arr[start] + arr[end]) / 2
    console.log(calc);
    if (calc === avg) return true
    else if (calc > avg) end -= 1
    else if (calc < avg) start += 1
  }

  return false
}

console.log(averagePair([1, 2, 3], 2.5)) //true
// console.log(averagePair([1, 3, 3, 5, 6, 7, 10, 12, 19], 8)) //true
// console.log(averagePair([], 4)) //false
