package fizzbuzz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fizzbuzz.model.Fizzbuzz;

/**
 * Servlet implementation class FizzbuzzController
 */
@WebServlet("/FizzbuzzController")
public class FizzbuzzController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public FizzbuzzController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String call = request.getParameter("call");
        request.setAttribute("answer", Fizzbuzz.answer(call));
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher
        	= context.getRequestDispatcher("/fizzbuzz.jsp");
        dispatcher.forward(request, response);
	}

}