import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int[] left;
	static int[] right;
	static int max;
	static int leftCardIndex;
	static int rightCardIndex;
	static int case1;
	static int case2;
	static int case3;
	

	
	
	public static int getMaxScore(int leftCardIndex, int rightCardIndex) {
		
		//case 1: 왼쪽 카드만 버리기
		//case 2: 왼쪽 , 오른쪽 카드 둘 다 버리기
		//case 3: 오른쪽 카드만 버리기 
			
		if(leftCardIndex<0 || rightCardIndex<0) {
			//왼쪽 더미 혹은 오른쪽 더미가 바닥나면 게임 종료 
			return 0;
		}//종료조건 
		
			
			if(right[rightCardIndex]<left[leftCardIndex]) {
				
				 case1 = getMaxScore(leftCardIndex-1,rightCardIndex);
				 case2 = getMaxScore(leftCardIndex-1,rightCardIndex-1);
				 case3 = getMaxScore(leftCardIndex,rightCardIndex-1)+right[rightCardIndex];
				
				int sum = Math.max(case1, case2);
				max= Math.max(sum, case3);
				
				
			}
			
			else {
				
				 case1 = getMaxScore(leftCardIndex-1,rightCardIndex);
				 case2 = getMaxScore(leftCardIndex-1,rightCardIndex-1);
				
				max= Math.max(case1, case2);
			}
			
			return max;
			
		}
	
	

    

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N=Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	left = new int[N];
    	right = new int[N];
    	
    	
    	max=0;
    	
    	leftCardIndex = (N-1);
    	rightCardIndex = (N-1);
    	//맨 마지막에 들어온 카드가 맨 위의 카드가 된다.
    	
    	for(int i=0;i<N;i++) {
    		left[i]=Integer.parseInt(st.nextToken());
    	}//왼쪽 카드
    	
  
    	st= new StringTokenizer(br.readLine());
    	
    	for(int i=0;i<N;i++) {
    		right[i]=Integer.parseInt(st.nextToken());
    	}//오른쪽 카드 
    	
    	
    	case1=0;case2=0;case3=0;
    	
    	System.out.println(getMaxScore(leftCardIndex, rightCardIndex));
    	
    	
    }
}
