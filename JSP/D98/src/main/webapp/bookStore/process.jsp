<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bookStore.MyCart" %>

<%
	ArrayList<MyCart> myCart = null;
	Object obj = session.getAttribute("cart");
	
	if(obj==null)
		myCart=new ArrayList<MyCart>();
	else
		myCart = (ArrayList<MyCart>)obj;
	
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	
	// 동일물품이 담겨있으면 cnt+=1
	int pos=-1;
	for (int i=0;i<myCart.size();++i){
		MyCart cart = (MyCart)myCart.get(i);
		if(cart.getName().equals(name)){
			pos=i;
			cart.setCnt(cart.getCnt()+1);
			break;
		}
	}
	
	// else, 새로운 MyCart 객체 생성해서 arrayList에 등록
	if (pos==-1){
		MyCart cart = new MyCart();
		cart.setName(name);
		cart.setPrice(Integer.parseInt(price.replaceAll(",", "")));
		cart.setCnt(1);
		myCart.add(cart);
	}
	
	// session에 arrayList등록 시키기
	// 이미 해당 정보가 있더라도 덮어씌워짐
	session.setAttribute("cart", myCart);
	
%>

<script>
	alert("장바구니에 담겼습니다.");
	history.go(-1);
</script>