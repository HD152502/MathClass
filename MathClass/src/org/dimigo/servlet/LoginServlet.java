package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// jsp 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("/WebClass/login");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.printf("id : %s, pwd: %s\n", id, pwd);

		// id, pwd 정합성 체크
		boolean result = true;
		System.out.println(result);
		if (result) {
			// 세션에 사용자 정보를 생성해서 담기
			HttpSession session = request.getSession();
			UserVO user = new UserVO();
			user.setId(id);
			user.setName("홍길동");
			user.setNickname("의적");

			session.setAttribute("user", user);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.printf("id : %s, pwd: %s\n", id, pwd);

		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		/*
		 * { "id" : "testid"
		 * 
		 * 
		 */
		/*
		 * out.println("{"); out.println("\"id\":"+"\""+id+"\"");
		 * out.println("}");
		 */

		// Json simple Library
		/*
		 * JSONObject json = new JSONObject(); json.put("id", id);
		 * out.write(json.toJSONString());
		 */

		// GSON
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		System.out.println(gson.toJson(map));
		out.write(gson.toJson(map));

	}

}
