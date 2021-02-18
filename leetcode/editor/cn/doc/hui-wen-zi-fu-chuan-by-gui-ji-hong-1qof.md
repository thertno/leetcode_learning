### 解题思路
1. 基本思路是 双指针，一个从左开始，一个从右开始，依次比较，遇到不符合条件的字符，对应指针跳过即可
2. 只有不相等，直接返回false
3. 直到俩指针相等，或左>右结束
4. ！！！！！！！！！ 不仅要求字母、还要求了数字！！！！
### 代码

```java
class Solution {
    public boolean isPalindrome(String s) {
        // 定义俩指针，一个从左开始，一个从右开始，俩指针相等时结束
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (right - left >= 1){
            // 只有是字母和数字的才生效
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```