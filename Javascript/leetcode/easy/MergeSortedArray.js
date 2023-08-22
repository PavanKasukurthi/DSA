const mergeSortedArray = (nums1, m, nums2, n) => {
  for (let i = 0, j = m; i < n; i++) {
    nums1[j++] = nums2[i]
  }

  nums1.sort()

  console.log(nums1)
}

mergeSortedArray([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3)
