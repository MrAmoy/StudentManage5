package bao;

public class PageBean {
	private int curPage = 1;	//当前页
	private int maxPage;	//总页数
	private int maxRowCount;	//总行数
	private int rowsPerPage = 10;	//每页行数
	private int startRow;	//循环的开始行数
	private int stopRow;	//循环的结束行数

	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxRowCount() {
		return maxRowCount;
	}
	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}
	public int getRowsPerPage() {
		return rowsPerPage;
	}
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public int getStopRow() {
		return stopRow;
	}
	
	public void maxPageSet() {
		if(maxRowCount % rowsPerPage == 0) {
			maxPage = (int)(maxRowCount / rowsPerPage);
		} else {
			maxPage = (int)(maxRowCount / rowsPerPage) + 1;
		}
	}
	
	public void calculate() {
		startRow = (curPage - 1) * rowsPerPage;
		if(maxRowCount - startRow >= 10) {
			stopRow = curPage * rowsPerPage;
		} else {
			stopRow = maxRowCount;
		}
	}
	
	/*
	private Connection conn = null;
	
	public List data;
	
	public PageBean() throws Exception {
		this.setPageBean();
	}
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getMaxRowCount() {
		return maxRowCount;
	}
	public void setMaxRowCount(int maxRowCount) {
		this.maxRowCount = maxRowCount;
	}
	
	public PageBean getResult(String page) throws Exception {
		PageBean pageBean = new PageBean();
		List data = new ArrayList();
		int pageNum = Integer.parseInt(page);
		conn = DBGet.getConnection();
		String sql = "select top" + pageNum * pageBean.rowsPerPage + " * from stu";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i = 1;
		Student student;
		while(rs.next()) {
			if(i > (pageNum - 1) * pageBean.rowsPerPage) {
				student = new Student();
				student.setStuId(rs.getString("stuID"));
				student.setStuName(rs.getString("stuName"));
				student.setStuSex(rs.getString("stuSex"));
				student.setStuAge(rs.getString("stuAge"));
				student.setStuWeight(rs.getString("stuWeight"));
				data.add(student);
			}
			i++;
		}
		DBGet.closeResultSet(rs);
		DBGet.closePreparedStatement(ps);
		DBGet.closeConnection(conn);
		
		pageBean.setCurPage(pageNum);
		pageBean.data = data;
		return pageBean;
	}
	
	//得到总行数
	public int getAvailableCount() throws Exception {
		int ret = 0;
		conn = DBGet.getConnection();
		String sql = "select * from stu";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ret++;
		}
		DBGet.closeResultSet(rs);
		DBGet.closePreparedStatement(ps);
		DBGet.closeConnection(conn);
		
		return ret;
	}
	
	public void setPageBean() throws Exception {
		this.setMaxRowCount(this.getAvailableCount());	//设置总行数
		if(this.maxRowCount % this.rowsPerPage == 0) {	//根据总行数计算出总页数
			this.maxPage = this.maxRowCount % this.rowsPerPage;
		} else {
			this.maxPage = this.maxRowCount % this.rowsPerPage + 1;
		}
	}
	*/
}
