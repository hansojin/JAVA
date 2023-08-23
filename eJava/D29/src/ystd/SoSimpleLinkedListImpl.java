package ystd;

class Rox<T>
{
	public Rox<T> nextRox;
	T item;

	public void store(T item) { this.item=item; }
	public T pullOut() { return item; }
}

class SoSimpleLinkedListImpl
{
	public static void main(String[] args)
	{
		Rox<String> RoxHead=new Rox<String>();
		RoxHead.store("First String");
		
		RoxHead.nextRox=new Rox<String>();
		RoxHead.nextRox.store("Second String");
		
		RoxHead.nextRox.nextRox=new Rox<String>();
		RoxHead.nextRox.nextRox.store("Third String");
		
		Rox<String> tempRef;
		
		/* 두 번째 박스에 담긴 문자열 출력 과정 */
		tempRef=RoxHead.nextRox;
		System.out.println(tempRef.pullOut());

		/* 세 번째 박스에 담긴 문자열 출력 과정 */
		tempRef=RoxHead.nextRox;
		tempRef=tempRef.nextRox;
		System.out.println(tempRef.pullOut());
	}
}
