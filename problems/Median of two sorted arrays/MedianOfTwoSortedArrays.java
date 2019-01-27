class Solution {
    
    public double getMedian(List<Integer> list){
        if(list.size() % 2 == 0) { // even no. of list
            return ( list.get(-1+list.size()/2) + list.get(list.size()/2) ) / 2.0;
        }
        else { // odd no. of list
            return list.get(list.size()/2);
        }
    }
    
    // m is either equal or bigger than n in size
    public List<Integer> sortedConcat(List<Integer> m, List<Integer> n){
        if(m.size() == 0 && n.size() == 0)
            return null;
        
        if(m.size() == 0)
            return n;
        
        if(n.size() == 0)
            return m;

        // after concatinating n to m, if the result is still sorted then return concat
        if(m.get(m.size()-1).intValue() <= n.get(0).intValue()){
            m.addAll(n);
            return m;
        }
        
        // after concatinating m to n, if the result is still sorted then return concat
        if(n.get(n.size()-1).intValue() <= m.get(0).intValue()){
            n.addAll(m);
            return n;
        }
        
        // this means n's first element is less than m's last
        // so perform a binary search of n's first in m
        int index = Collections.binarySearch(m,n.get(0));
        
        // if key is absent in m then its eligible index
        index = index < 0 ? (-1*index-1) : index;
        
        // since binary search doesn't guarantee lastIndexOf the key, we'll have to check it
        while(index < m.size()-1){
            int index1;
            if(m.get(index+1).intValue() == n.get(0).intValue()){
                 index1 = Collections.binarySearch(m.subList(index+1,m.size()),n.get(0));
                 // if key is absent in m then its eligible index
                 index1 = index1 < 0 ? (-1*index1-1) : index1;
                index = index + 1 + index1;
            }
            else break;
        }
        
        List<Integer> concatList = new ArrayList<Integer>(m.subList(0,index));
        concatList.add(index, n.get(0));
        
       List<Integer> n0 = n.subList(1,n.size());
       List<Integer> m0 = m.subList(index,m.size());
        
        if(m0.size() >= n0.size()){
            m = m0;
            n = n0;
        }
        else {
            m = n0;
            n = m0;
        }
        List<Integer> sortedAppend = sortedConcat(m,n);

        if(sortedAppend != null)
            concatList.addAll(sortedAppend);
        return concatList;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // convert sorted int arrays to lists
        List<Integer> m = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> n = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        
        // recursion to find median
        if(m.size() >= n.size()){
            return getMedian(sortedConcat(m,n));       
        }
        else {
            return getMedian(sortedConcat(n,m));
        }
    }
}
