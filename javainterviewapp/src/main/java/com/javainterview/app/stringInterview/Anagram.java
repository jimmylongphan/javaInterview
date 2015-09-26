package stringInterview;



public class Anagram extends comparable<Anagram> {
    public String value;
    public Anagram( String s ) {
        this.value = s;
    }
    
    public compare ( Anagram a1, Anagram a2 ) {
        char[] char1 = a1.value.toCharArray();
        char[] char2 = a2.value.toCharArray();
        
        boolean same = Arrays.equals( char1, char2 );
        return same;
    }
    
}