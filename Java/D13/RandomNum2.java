import java.util.*;

class RandomNum2{
	public static void main(String[] args){
		for(int j=0;j<5;j++){
			List<Integer> numList = new ArrayList<>();
			for(int i=1;i<=45;i++)
				numList.add(i);
	
			Collections.shuffle(numList);	
			numList=numList.subList(0,6);
			Collections.sort(numList);

			System.out.printf("line %d : ",j+1);
			for (int i : numList)
				System.out.print(i+"\t");
			System.out.println();
		}
	}
}