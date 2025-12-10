/* Problem Link : https://leetcode.com/problems/search-suggestions-system/ */

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>>result = new ArrayList<>();

        String prefix = "";

        for(char c : searchWord.toCharArray()){

            prefix+=c;
            int start = lowerBounds(products, prefix);
            List<String>suggestions;

            for(int i = 0; i < products.length && suggestions.size() < 3; i++){
                if(products[i].startsWith(prefix)){
                    suggestions.add(products[i]);
                }else{
                    break;
                }
            }
        result.add(suggestions);
        }
    return result;
    }

    private int lowerBounds(String[] products, String prefix){

        int low = 0, high = products.length - 1;

        while(low <= high){

            int mid = low + (high - low)/2;
            if(products[mid].compareTo(prefix) < 0){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
    return low;
    }
}