class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charSequence = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charSequence[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int min = Math.min(words[i].length(), words[j].length());
                for (int k = 0; k < min; k++) {
                    int chari = words[i].charAt(k);
                    int charj = words[j].charAt(k);
                    if (charSequence[chari - 'a'] < charSequence[charj - 'a']) {
                        break;
                    } else if (charSequence[chari - 'a'] > charSequence[charj - 'a']) {
                        return false;
                    } else if (k == min - 1 && words[i].length() > words[j].length()) {
                        return false;
                    }
                }

            }
        }
        return true;

    }
}