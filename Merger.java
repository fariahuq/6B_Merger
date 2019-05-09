/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {

    	// sets up two sorted lists
    	ArrayList<String> list0 = new ArrayList<String>();
    	for (int i = start0; i < start1; i++) {
    		list0.add(usersData.get(i));
    	}
    	ArrayList<String> list1 = new ArrayList<String>();
    	for (int i = start1; i < nItems; i++) {
    		list1.add(usersData.get(i));
    	}

    	int counter0 = 0;
    	int counter1 = 0;
    	int listCounter = start0;
    	while( counter0 < list0.size() && counter1 < list1.size()) {
    		if (list0.get(counter0).compareTo(list1.get(counter1)) < 0) {
    			usersData.set( listCounter, list0.get(counter0));
    			counter0++;
    		}
    		else {
    			usersData.set( listCounter, list1.get(counter1));
    			counter1++;
    		}
    		listCounter++;
    	}

    	// adds any leftover elements
    	while( counter0 < list0.size()) {
    		usersData.set( listCounter, list0.get(counter0));
    		counter0++;
    		listCounter++;
    	}
    	while( counter1 < list1.size()) {
    		usersData.set( listCounter, list1.get(counter1));
    		counter1++;
    		listCounter++;
    	}
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           ) {
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        }
        return true;
    }
}
