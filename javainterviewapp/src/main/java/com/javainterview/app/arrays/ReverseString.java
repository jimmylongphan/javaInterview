/**
 * Reverse a string
 */

public class ReverseString {

      /**
       */
    public String reverseString( String s ) {
        if ( s == null || s.isEmpty() ) {
            return s;
        }

        String result = "";
        for ( int i=s.length() - 1; i>=0 ; i--) {
            result = result + s.charAt(i);
        }

        return result;
    }


    /**
     * If we want to reduce space usage, then the incoming parameter
     * should be a char[] sArray.
     */
    public String reverseStringInPlace( String s ) {
        if ( s == null || s.isEmpty() ) {
            return s;
        } else if ( s.length() == 1 ) {
            return s;
        }

        // There is no putChar method for java String
        char temp;
        char[] array = new char[s.length()];
        for ( int i=0, j=s.length() -1; i<s.length()/2; i++, j--) {
            temp = s.charAt(i);
            array[i] = s.charAt(j);
            array[j] = temp;
        }

        return new String(array);
    }
    
}

