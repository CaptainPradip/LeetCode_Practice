/**
 * @param {string} s
 * @param {number} count
 * @return {number}
 */
var equalCountSubstrings = function(s, count) {
    const uniqueChars = new Set(s);
    const n = s.length;
    
    let res = 0;
    
    for (let uniques = 1; uniques <= uniqueChars.size; ++uniques) {
        const charCounts = new Array(26).fill(0);
        const len = uniques * count;
        
        let hasCount = 0; 
        let left = 0;
        
        for (let i = 0; i  < n; ++i) {
            const endIdx = s.charCodeAt(i) - 97;
            
            ++charCounts[endIdx];
            
            if (charCounts[endIdx] === count) ++hasCount;
            
            if (i >= len) {
                const startIdx = s.charCodeAt(left) - 97;
                
                if (charCounts[startIdx] === count) --hasCount;
                --charCounts[startIdx];
                ++left;
            }
            
            if (hasCount == uniques) ++res;
        }
    } 
    
    return res;
};