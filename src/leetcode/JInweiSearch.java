package leetcode;

public class JInweiSearch {


	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		int start = -90;
		int end = 90;
		int target = 80;
		sb = search(start,end,target);
		System.out.println(sb.toString());
	}

	private static StringBuilder search(int start, int end, int target) {
		StringBuilder stringBuilder= new StringBuilder();
		int mid;
		if((start + end)%2 == 0){
			mid = (start+end)/2;
		}else {
			mid = (start+end)/2+1;
		}
		if(target == mid){
			stringBuilder.append("1");
			return stringBuilder;
		}
		if(target < mid){
			stringBuilder.append(search(start, mid - 1, target));
		}else {
			stringBuilder.append(search(mid+1, end, target));
		}
		return stringBuilder;
	}
}
