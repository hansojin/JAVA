package bean.beanTest;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	public MemberDTO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
