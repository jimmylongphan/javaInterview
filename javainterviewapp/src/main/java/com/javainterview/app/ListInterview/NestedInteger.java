package com.javainterview.app.ListInterview;

public interface NestedInteger implements NestedIntegerIntf {
    public List<Object> values;
    
    /*
    @return true if this NestedInteger holds a single integer, rather than a nested list.
    */
    public boolean isInteger() {
        // check size of list
        if (values.size() > 1) {
            return false;
        } 
        
        // check type of object in list
        return values.get(0) instanceof Integer;
    }
    
    /*
    @return the single integer that this NestedInteger holds, if it holds a single integer
    Return null if this NestedInteger holds a nested list
    */
    public Integer getInteger() {
        // check if we can actually get the value
        if ( !isInteger() ) {
            return null;
        }
        
        // it is possible to get the value
        return (Integer) values.get(0);
    }
    
    /*
    @return the nested list that this NestedInteger holds, if it holds a nested list
    Return null if this NestedInteger holds a single integer
    */
    public List<NestedInteger> getList() {
        // check if we actually get a list
        if ( isInteger() ) {
            return null;
        }
        
        // loop through the list
        for ( Object o : values ) {
            if( !o instanceof Integer) {
                return o;
            }
        }
    }
}