package com.smf.my.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smf.member.model.vo.Member;
import com.smf.my.model.service.MyPageService;

/**
 * Servlet implementation class MyWishListDeleteController
 */
@WebServlet("/wishListItemDel.me")
public class MyWishListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWishListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		String pName = request.getParameter("pName");
		
		int result = new MyPageService().wishlistItemDelete(userId, pName);
		
		if( result>0 ) {
			
			request.getSession().setAttribute("alertMsg", "삭제되었습니다.");
			
			response.sendRedirect(request.getContextPath()+"/mypagewishlist.me");
		}else {
			System.out.println("삭제 오류!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
