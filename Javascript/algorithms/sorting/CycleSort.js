const CycleSort = (arr) => {
    let i = 0;
    while (i < arr.length) {
        const correctIndex = arr[i] - 1;
        if (arr[i] !== arr[correctIndex]) {
            [arr[i], arr[correctIndex]] = [arr[correctIndex], arr[i]];
        } else {
            i++;
        }
    }
    return arr;
}

let arr = [5,4,3,2,1];
console.log(CycleSort(arr));