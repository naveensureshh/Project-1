import java.util.*;

public class Main {
    
    public static int[] decToBin(int num) {
        if (num < -128 || num > 127) {
            System.out.println("Number out of range");
            return null;
        }
        int[] result = new int[8];
        if (num < 0) {
            result[0] = 1; 
        } else {
            result[0] = 0; 
        }
        num = Math.abs(num) % 128;
        for (int i = 7; i > 0; i--) {
            result[i] = num % 2;
            num = num / 2;
        }
        return result;
    }

    public static int binToDec(int[] binary) {
        if (binary.length != 8) {
            System.out.println("incorrect binary");
            return 0;
        }
        int num = 0;
        for (int i = 7; i > 0; i--) {
            num = num + binary[i] * (int) Math.pow(2, 7 - i);
        }
        if (num == 0 && binary[0] == 1) {
            return -1;
        }
        if (binary[0] == 1) {
            num = -1 * num;
        }
        return num;
    }

    public static int[] comp1s(int[] binary) {
        int result[] = new int[8];
        for (int i = 7; i > 0; i--) {
            if (binary[i] == 1) {
                result[i] = 0;
            } else if (binary[i] == 0) {
                result[i] = 1;
            }
        }
        result[0] = binary[0];
        return result;
    }

    public static int[] comp2s(int[] binary) {
        int result[] = new int[8];
        boolean flag = true;
        for (int i = 7; i > 0; i--) {
            if (flag && binary[i] == 0) {
                result[i] = 0;
                continue;
            } else if (flag && binary[i] == 1) {
                result[i] = 1;
                flag = false;
                continue;
            }
            if (binary[i] == 1) {
                result[i] = 0;
            } else if (binary[i] == 0) {
                result[i] = 1;
            }
        }
        result[0] = binary[0];
        return result;
    }

    public static int[] excess128(int[] bin1) {
        int carry = 0;
        int[] bin2 = { 1, 0, 0, 0, 0, 0, 0, 0 };
        int result[] = new int[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (bin1[i] + bin2[i] + carry) % 2;
            carry = (bin1[i] + bin2[i] + carry) / 2;
        }
        return result;
    }

    public static String arrToStr(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + arr[i];
            if (i == 3) {
                result = result + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int choice
