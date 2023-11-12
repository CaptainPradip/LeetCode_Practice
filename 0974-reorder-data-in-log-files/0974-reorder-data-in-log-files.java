class Solution {
    public String[] reorderLogFiles(String[] logs) {
        /**
        We can translate the problem into the following rules:

        1). The letter-logs should be prioritized above all digit-logs.

        2). Among the letter-logs, we should further sort them firstly based on their contents, and then on their identifiers if the contents are identical.

        3). Among the digit-logs, they should remain in the same order as they are in the collection.
         */
         Arrays.sort(logs, (str1,str2)->{
                String [] split1= str1.split(" ", 2);
                String [] split2= str2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if(!isDigit1 && !isDigit2){
                    int comp = split1[1].compareTo(split2[1]);
                    if(comp!=0){
                        return comp;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                if(!isDigit1 && isDigit2){
                    return -1;
                }else if(isDigit1 && !isDigit2){
                    return 1;
                }else {
                    return 0;
                }
         });
        return logs;
    }
}