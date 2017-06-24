package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.loginCheck;

public class AuthorityFilter implements Filter {
	private FilterConfig config;
	
	public void init(FilterConfig config) {
		this.config = config;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
		// 获取该Filter的配置参数
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String doLogin = config.getInitParameter("doLogin");
		// 设置request编码用的字符集
		request.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest)request;
		HttpServletResponse respon = (HttpServletResponse)response;
		HttpSession session = requ.getSession(true);
		
		String username = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("pw");
		// 获取客户请求的页面
		String requestPath = requ.getServletPath();
		//System.out.println(requestPath); 
		// 如果登录的用户名和密码不正确，且用户请求的既不是登录页面，也不是处理登录的页面
		if(!loginCheck.Check(username, password) && !requestPath.endsWith(loginPage) && !requestPath.endsWith(doLogin)) {
			request.setAttribute("tip" , "您还没有登录");
			// forward到登录页面
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
		this.config = null;
	}
}
