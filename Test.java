给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int longestPalindrome(String s) {
        int[] arr=new int[52];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a'&&c<='z'){
                arr[c-'a']++;
            }if(c>='A'&&c<='Z'){
                arr[c-'A'+26]++;
            }
        }
        int sum=0;
        for(int i=0;i<52;i++){
            if(arr[i]%2!=0){
                sum+=arr[i]-1;
                arr[i]=1;
            }else{
                sum+=arr[i];
                arr[i]=0;
            }
        }
        for(int i:arr){
            if(i==1){
                sum+=1;
                return sum;
            }
        }
        return sum;
    }
}


给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")){
            return 0;
        }
        StringBuffer sb=new StringBuffer();
        sb.append(s.charAt(0));
        int len=1;
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            int a=sb.toString().indexOf(c);
            if(a<0){
                sb.append(c);
                len=Math.max(len,sb.toString().length());
            }else{
                sb.delete(0,a+1);
                sb.append(c);
            }
        }
        return len;
    }
}

给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
class Solution {
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r&&s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }
        if(l>=r||validPalindrome(s,l+1,r)||validPalindrome(s,l,r-1)){
            return true;
        }
        return false;
    }

    private boolean validPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}


给定两个字符串，你需要从这两个字符串中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。

子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。

输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}



