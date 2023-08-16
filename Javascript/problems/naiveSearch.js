const naiveSearch = (str, searchStr) => {
  if (str === searchStr) return 1

  let count = 0
  let start = 0
  let end = searchStr.length

  while (end <= str.length) {
    if (str.substring(start, end) === searchStr) count++

    start++
    end++
  }

  return count
}

//RECURSIVE
const naiveSearchRecursive = (str, searchStr) => {
    let count = 0

    if(str.length === 0) return count;
    if(str.substring(0, searchStr.length) === searchStr) count++;

    count = count + naiveSearchRecursive(str.slice(1), searchStr)

    return count
}

console.log(naiveSearch('anakin', 'kin'))
