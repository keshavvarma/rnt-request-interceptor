package ai.rnt.interceptor.filter;
//Java Program to Illustrate MyBlockFilter

//Importing required classes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

//Importing all servlet classes
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//Class
//Implementing Filter class

public class RequestFilter implements Filter {

	ArrayList<String> localIps = new ArrayList<String>(Arrays.asList("127.0.0.1", "localhost", "0:0:0:0:0:0:0:1"));

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	// Method
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;

		System.out.println("In Filter");
		String ip = req.getRemoteAddr();
		System.out.println("IP:" + ip);
		getRequestHeadersInMap(httpRequest);
		System.out.println("Header printed");
		
		PrintWriter out = resp.getWriter();

		if (localIps.indexOf(ip) > -1) {
			// out.print(",<h2>Your ip address is blocked by this websites</h2>");
		} else {
			fc.doFilter(req, resp);
		}
	}

	private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {
		System.out.println("in header check");
		Map<String, String> result = new HashMap<>();

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			result.put(key, value);
			System.out.println(key + ":\t" + value);
		}
		
		String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }
        
		/*
		 * Map<String, List<String>> headersMap =
		 * Collections.list(httpRequest.getHeaderNames()) .stream()
		 * .collect(Collectors.toMap( Function.identity(), h ->
		 * Collections.list(httpRequest.getHeaders(h)) ));
		 */

		return result;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
