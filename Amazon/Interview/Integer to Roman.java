class Solution {
    public String intToRoman(int num) {

    	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    	StringBuilder result = new StringBuilder();

    	int valueIndex = 0;

    	while (num > 0) {
    		int value = values[valueIndex];

    		if (num >= value) {
    			num -= value;
    			result.append(symbols[valueIndex]);
    		} else {
    			valueIndex ++;
    		}
    	}

    	return result.toString();
        /*
        String result = "";	

        while (num > 0) {

        	if (num >= 1000) {
        		num -= 1000;
        		result += "M";
        	} else if (num >= 900) {
        		num -= 900;
        		result += "CM";
        	} else if (num >= 500) {
        		num -= 500;
        		result += "D";
        	} else if (num >= 400) {
        		num -= 400;
        		result += "CD";
        	} else if (num >= 100) {
        		num -= 100;
        		result += "C";
        	} else if (num >= 90) {
        		num -= 90;
        		result += "XC";
        	} else if (num >= 50) {
        		num -= 50;
        		result += "L";
        	} else if (num >= 40) {
        		num -= 40;
        		result += "XL";
        	} else if (num >= 10) {
        		num -= 10;
        		result += "X";
        	} else if (num >= 9) {
        		num -= 9;
        		result += "IX";
        	} else if (num >= 5) {
        		num -= 5;
        		result += "V";
        	} else if (num >= 4) {
        		num -= 4;
        		result += "IV";
        	} else {
        		num --;
        		result += "I";
        	}
 

        }

        return result;
        */


    }
}