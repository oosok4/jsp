package kr.or.ddit.Dd.model;

public class DdVo {
	
	private String uri;
	private String classname;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "DdVo [uri=" + uri + ", classname=" + classname + "]";
	}
	public DdVo(String uri, String classname) {
		super();
		this.uri = uri;
		this.classname = classname;
	}

	public DdVo(){
		
	}
	
}
