package ai.rnt.filter;
//Java Program to Illustrate MyBlockFilter

//Importing required classes
import java.io.IOException;
import java.io.PrintWriter;

//Importing all servlet classes
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Class
//Implementing Filter class

public class RequestFilter implements Filter {

	// Method
	/*
	 * public void init(FilterConfig config) throws ServletException { }
	 */

	// Method
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		System.out.println("In Filter");
		String ip = req.getRemoteAddr();
		System.out.println("IP:" + ip);


		PrintWriter out = resp.getWriter();

		if (ip.equals("127.0.0.1")) {
			out.print(",<h2>Your ip address is blocked ny this websites</h2>");
		}
		else {
			fc.doFilter(req, resp);
		}
	}

	// Method
	// public void destroy() {}
}
