package BinaryGap;

public class BinaryGap {

    public int getLargestGap(int n) {


        //iterate over binary digits
        //check if 1 or 0
        //if 1 count 0s
        //stop on 1
        //record this
        //repeat
        //use larger count

        int count = 0;
        boolean hitOneAlready = false;
        while (n != 0) {
            int lastBinaryDigit = n % 2;

            if (!hitOneAlready && lastBinaryDigit == 1) {
                hitOneAlready = true;
            }

            if (lastBinaryDigit != 1 && hitOneAlready) {
                count++;
            }

            n = n/2;
        }

        return count;
    }
}
