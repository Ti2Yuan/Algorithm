package com.chen.offer;

/**
 * 题目描述: 整数中1出现的次数（从1到n整数中1出现的次数）
 * @author tichen
 *
 *这种方法的思路大概是这样的（懒得动手打了，直接copy）：

    按每一位来考虑，

    1)此位大于1，这一位上1的个数有 ([n / 10^(b+1) ] + 1) * 10^b
    2)此位等于0，为 ([n / 10^(b+1) ] ) * 10^b
    3)此位等于1，在0的基础上加上n mod 10^b + 1

    举个例子：


    30143:
    由于3>1,则个位上出现1的次数为(3014+1)*1
    由于4>1,则十位上出现1的次数为(301+1)*10
    由于1=1，则百位上出现1次数为(30+0)*100+(43+1)
    由于0<1，则千位上出现1次数为(3+0)*1000

    注:以百位为例，百位出现1为100~199，*100的意思为单步出现了100~199，100次，*30是因为出现了30次100~199,+(43+1)是因为左后一次301**不完整导致。
    如果还不懂，自己拿纸和笔大致写下，找下规律，就能推导出来了！
    两外，需要注意一点：由于测试系统要求的输入数据最大为1,000,000,000，因此用int会溢出，要用long long，另外比较坑跌的一点是a可能比b大，居然都没有说明，有点坑了。
 */

public class NumberOf1Between1Andn {

	public static void main(String[] args) {
		int num = 13;
		System.out.println(countNum1(num));
	}
	
	public static int countNum1(int num){
		if(num <= 0){
			return 0;
		}
		
		int count = 0;
		int current; //当前位
		int base = 1; //当前位的基
		int remain = 0;  //当前位为1时，后面位剩余的数（就是不完整的部分）中1出现的次数
		
		while(num>0){
			current = num%10;
			num = num/10;
			
			if(current > 1){
				count += (num+1) * base;
			}else if (current == 1) {
				count += num * base + (remain+1);
			}else{
				count += num * base;
			}
			remain += current*base;
			base *= 10;
		}
		return count;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
