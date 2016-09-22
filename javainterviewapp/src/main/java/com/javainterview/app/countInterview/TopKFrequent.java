package com.javainterview.app.countInterview;


/**
 * LeetCode: 347
 * Company: Yelp, Coupang
 * Tags: hash table, heap
 * 
 * Idea:
 * First build a hashmap to keep counts of all the numbers.
 * Key: number
 * value: count or frequency
 * O(n)
 * 
 * Secondly we create a bucket array of nums.length + 1
 * Each index in the array represents the count.
 * So the highest index will be the highest count.
 * Value is the list of numbers or keys with this count.
 * 
 * Loop backwards from the bucket array starting from highest index or count
 * If an entry exists for this count, then we add all the numbers or keys
 * to the result.
 * O(n)
 * 
 * Once our result reaches size k, then we return.
 * 
 * If we sort or use priorityQueue, then it is O(n log n)
 */
public class TopKFrequent {
    
    /**
     * @param nums the array to count
     * @param k the top numbers to get
     * @return list of size k with highest frequent numbers
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Each index is the count
        // Value is the List of numbers with this count
    	List<Integer>[] bucket = new List[nums.length + 1];
    	
    	// count all the numbers in the input
    	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    
        // loop through numbers
        // increment their count
    	for (int n : nums) {
    		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    	}
    
        // loop through all the numbers, or use keys
    	for (int key : frequencyMap.keySet()) {
    	    // get the count of the number
    		int frequency = frequencyMap.get(key);
    		
    		// add into the bucket the frequency value
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		
    		// for this count, this is the number
    		bucket[frequency].add(key);
    	}
    
        // instantiate the result
    	List<Integer> res = new ArrayList<>();
    
        // iterate backwards from the bucket starting from highest index
        // the highest index is also the highest count
        // stop when index less than 0 or our result has top k
    	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
    	    if (bucket[pos] == null) {
    	        continue;
    	    }
    	    
    	    // this bucket is not null, then we have this count
		    List<Integer> subList = bucket[pos];
		    int subListSize = subList.size();
		    
		    // Example trimming sublist
		    // k is 5
		    // res is 4
		    // sublist is 2
		    // 5 - 4 = 1, we can only add 1 more
		    if (res.size() + subListSize > k) {
    		    // add sublist so we do not pass k
		        subListSize = k - res.size();
    		    // exclusive
    		    subList = subList.subList(0, subListSize);
		    }
		    
		    // only add the values that can fit
			res.addAll(subList);
    	}
    	
    	// the result should have k elements
    	// each element is added starting from the highest index or count
    	return res;
    }
    
}