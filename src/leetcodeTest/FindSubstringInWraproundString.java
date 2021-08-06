package leetcodeTest;

import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;

public class FindSubstringInWraproundString {
	public static void main(String[] args) {
		String p="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		SolutionfindSubstringInWraproundString solutionfindSubstringInWraproundString=new SolutionfindSubstringInWraproundString();
		
		System.out.println(solutionfindSubstringInWraproundString.findSubstringInWraproundString(p));
	}

}


class SolutionfindSubstringInWraproundString {
    public int findSubstringInWraproundString(String p) {
    	//create meroy 
    	Map<String, Integer> subStrMap=new HashMap<>();
    	int strLen=p.length();
    	for (int i = 0; i <strLen; i++) {
			int startIndex=i;
			int addindex=0;
    		for (int j = 0; j < strLen-i; j++) {
    			if (j==0) {
    				addindex=1;
    				if (subStrMap.containsKey(p.charAt(i))) {
        				continue;        				
        			}else {	
        				subStrMap.put(String.valueOf(p.charAt(i)), 1);
        			}    				
				}else {
	    			int diff=p.charAt(i+addindex-1)-p.charAt(i+addindex);
	    			if (diff==-1||diff==25) {	
	        			if (subStrMap.containsKey(p.substring(startIndex, i+addindex+1))) {
	        				addindex+=1;
	        				continue;
	        			}else {	
	        				if (p.substring(startIndex, i+addindex+1).equals("")) {
	        					addindex+=1;
	        					continue;
							}
        					subStrMap.put(p.substring(startIndex, i+addindex+1), 1);
	        				addindex+=1;
	        			}
					}else {
						startIndex=i+j;
						addindex=1;
					}
				}
			}			
		}
    	return subStrMap.size();
    }   
}