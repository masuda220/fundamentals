package com.example.fundamentals.numeric;

import java.util.Arrays;

class DecimalFormat {

    long value ;
    int scale;

    DecimalFormat( Decimal decimal) {
        this.value = decimal.value;
        this.scale = decimal.scale;
    }

    String layout() {
        char[] chars = Long.toString(Math.abs(value)).toCharArray();
        StringBuilder result = new StringBuilder();

        if(value < 0) result.append('-');

        if(scale == 0) {
            result.append(separated(chars));
            return result.toString();
        }

        int zeroPaddingSize = scale - chars.length;

        if( zeroPaddingSize >= 0 ) {
            zeroPadding(chars, result);
        } else {
            noZeroPadding(chars, result);
        }

        return result.toString();
    }

    private void zeroPadding(char[] chars, StringBuilder result) {
        result.append("0.");
        result.append(zeros(scale - chars.length));
        result.append(chars);
    }

    private void noZeroPadding(char[] chars, StringBuilder result) {
        result.append(separated(Arrays.copyOf(chars,chars.length - scale)));
        result.append('.');
        result.append(chars, chars.length - scale, scale);
    }

    private String zeros(int size) {
        StringBuilder result = new StringBuilder();
        for(int i = 0 ;  i < size ; i++ ) {
            result.append('0');
        }
        return result.toString();
    }

    private String separated(char[] chars) {
        StringBuilder result = new StringBuilder();
        int groupCount = (chars.length - 1) / 3;
        int leadingCount = chars.length - (groupCount * 3) ;

        result.append(chars, 0, leadingCount );
        for(int count = 0 ; count < groupCount ; count++) {
            result.append(',');
            int start = leadingCount + count * 3;
            result.append(chars, start,  3 );
        }
        return result.toString();
    }

}
