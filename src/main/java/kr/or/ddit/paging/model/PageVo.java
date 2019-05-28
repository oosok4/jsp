package kr.or.ddit.paging.model;

public class PageVo {

	private int page;
	private int pageSize;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public PageVo(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public PageVo(){
		
	}
	
	@Override
	public String toString() {
		return "pageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
}
