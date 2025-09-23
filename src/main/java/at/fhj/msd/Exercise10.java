package at.fhj.msd;

class Exercise10 {

    private int pointer1;
    private int pointer2;

    public boolean isPalindrome(String s) {
        String[] sArr = s.split("");
        pointer1 = 0;
        pointer2 = sArr.length - 1;

        while (pointer2 > pointer1) {
            if (!(sArr[pointer1].matches("[A-Za-z0-9]"))) {
                  pointer1++;
                  continue;
            }
            if (!(sArr[pointer2].matches("[A-Za-z0-9]"))) {
                  pointer2--;
                  continue;
            }
            if (!(sArr[pointer1].equalsIgnoreCase(sArr[pointer2]))) {
                return false;
            }
            pointer1++;
            pointer2--;
        }
        return true;
    }
}
