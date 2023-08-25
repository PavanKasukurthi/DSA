const RotateArray = (nums, k) => {
    k = k % nums.length;
    const spliced = nums.splice(nums.length - k, k);
    nums.unshift(...spliced);
    console.log(nums);
}

RotateArray([1, 2, 3, 4, 5, 6, 7], 3);
