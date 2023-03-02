
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minimart.domain.Product;
import com.minimart.repository.OrderRepository;
import com.minimart.repository.Repository;

/**
 * Servlet implementation class Minimart
 */
@WebServlet(name = "minimart.do", urlPatterns = { "/minimart.do" })
public class Minimart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Minimart() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("list-product".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("products.jsp").forward(request, response);
		} else if ("create-product".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("form.html").forward(request, response);
		} else if ("delete-product".equals(request.getParameter("action"))) {
			Repository repo = new Repository();
			repo.delete(request.getParameter("id"));
			response.sendRedirect("minimart.do?action=list-product");
		} else if ("edit-product".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
		else if ("order-new".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		else if ("list-order".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("list-order.jsp").forward(request, response);
		}
		else if ("order-detail".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("order-detail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("minimart.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("update-product".equals(request.getParameter("action"))) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			double price = Integer.parseInt(request.getParameter("price"));
			Repository repo = new Repository();
			Product pUpdate = new Product(code, name, type, price);
			repo.update(code, pUpdate);

			response.sendRedirect("minimart.do?action=list-product");
		} else if("order-post".equals(request.getParameter("action"))){
			OrderRepository order = new OrderRepository();
			order.orderNew(request);
			response.sendRedirect("minimart.do?action=list-order");

		}else {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String type = request.getParameter("type");
			double price = Integer.parseInt(request.getParameter("price"));
			Repository repo = new Repository();
			Product productSave = new Product(code, name, type, price);
			repo.saveData(productSave);

			response.sendRedirect("minimart.do");
		}
	}

}
