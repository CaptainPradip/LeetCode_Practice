/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function (s) {
    let arr = s.trim().split(" ");
    let result = [];

    let result1 = "";
    arr.forEach(s => {
        if (s.trim() != "") {
            result.push(s);
        }
    })
    let i = 0;
    let j = result.length - 1;
    while (i < j) {
        let temp = result[i];
        result[i] = result[j];
        result[j] = temp;
        i++;
        j--;
    }
    result.forEach((s, index )=> {
        result1 += s;
        if(index!=result.length - 1){
            result1 += " ";
        }
        
    })
    return result1;

};