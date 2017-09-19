package sample.bank.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class SendFacebookNotification
 */
public class SendFacebookNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendFacebookNotification() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String appToken = "646657215481679|dDzcYwqR0_RKBFkHPiM09xOQ83Q";
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = request.getReader();
			String inputLine = null;
			StringBuffer b = new StringBuffer();
			while ((inputLine = bufferedReader.readLine()) != null) {
				b.append(inputLine + "\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}


		String code = (String) request.getParameter("code");
		String access_token = getAccessToken(code);

		String faceBookId = getFacebookId(access_token,request);
		
		sendNotification(faceBookId,appToken);
		
		request.getSession().setAttribute("faceBookId", faceBookId);

		PrintWriter out = response.getWriter();
		out.println("<HTML>\n" + "<HEAD><TITLE>Hello</TITLE></HEAD>\n" + "<BODY>\n" + "<H1> Successfully Notification sent on"
				+ " FaceBook Id. To log-in, please click  <A href='first.jsp'><I>here</I></A> </H1>\n" 
				+ "</BODY></HTML>");
	}

	private String getAccessToken(String code) {
		String accessToken = null;

		try {
			String g = "https://graph.facebook.com/oauth/access_token?client_id=646657215481679&redirect_uri="
					+ URLEncoder.encode("http://royalbank.mybluemix.net/RoyalBank/SendFacebookNotification", "UTF-8")
					+ "&client_secret=34d72b3016774ab86a08e12eed1ec91f&code=" + code;
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			accessToken = b.toString();
			if (accessToken.startsWith("{"))
				throw new Exception("error on requesting token: " + accessToken + " with code: " + code);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accessToken;

	}

	private String getFacebookId(String token, HttpServletRequest request) {

		String graph = null;
		String facebookId = null;
		try {
			//String g = "https://graph.facebook.com/me?" + token;
			String g = "https://graph.facebook.com/me?fields=id,name,email&" + token;
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			graph = b.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//System.out.println("graph::" + graph);

		String name = null;
		String email = null;

		try {
			JSONObject json = new JSONObject(graph);
			facebookId = json.getString("id");
			name = json.getString("name");
			email = json.getString("email");
			request.getSession().setAttribute("name", name);
			//System.out.println("facebookId::" + facebookId + " ::email::" + email);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return facebookId;
	}
	
	private void sendNotification(String facebookId , String accessToken){
		try {
			Date currentDate = new Date();
			String message = "Welcome message from PrasNotificationApp at::"+currentDate;
			URL url = new URL("https://graph.facebook.com/"+facebookId+"/notifications");
			Map<String, Object> params = new LinkedHashMap<String, Object>();
			params.put("access_token", accessToken);
			params.put("template", message);
			
			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0)
					postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);

			Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

/*			for (int c; (c = in.read()) >= 0;)
				System.out.print((char) c);*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
