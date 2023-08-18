package Num;

import java.util.StringTokenizer;

class TokenizeString{	
	public static void main(String[] args){
		String strData="11:22:33:44:55";
		StringTokenizer st=new StringTokenizer(strData, ":");
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
	}
}

/*
int countTokens() 
 : 남아있는 token의 개수를 반환
 : 전체 token의 갯수가 아닌 현재 남아있는 token 개수
 
Object nextElement() | String nextToken()
 : 다음의 토큰을 반환합니다. 
*/