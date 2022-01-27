package apcs.unit6.frq;

public class Mountain {
    public static boolean isIncreasing(int[] array, int stop) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] < array[i+1] && i < stop) {
                
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isDecreasing(int[]array, int start) {
        for(int i = start; i < array.length; i++) {
            if(array[i] > array[i+1] && i < array.length) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static int getPeakIndex(int[] array) {
        int index = 0;
        
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] < array[i+1]) {
                index++;
            }
        }
        return index;
    }

    public static boolean isMountain(int[] array) {
        int peak = getPeakIndex(array);
        if(isIncreasing(array, peak) && isDecreasing(array, peak)) {
            return true;
        } else {
            return false;
        }
    }
}
