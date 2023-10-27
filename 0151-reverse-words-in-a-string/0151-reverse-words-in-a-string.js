/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
   return s.trim().split(" ").filter((str)=> str.trim().length).reverse().join(" ");
};