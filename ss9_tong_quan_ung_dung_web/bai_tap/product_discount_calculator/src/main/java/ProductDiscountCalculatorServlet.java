import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDiscountCalculatorServlet", urlPatterns = {"/display-discount"})
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
        double discountAmount = listPrice*discountPercent*0.01;
        double discountPrice = listPrice - discountAmount;
        String productDescription = request.getParameter("productDescription");

        request.setAttribute("ProductDescription",productDescription);
        request.setAttribute("ListPrice",listPrice);
        request.setAttribute("DiscountAmount",discountAmount);
        request.setAttribute("DiscountPrice",discountPrice);
        request.getRequestDispatcher("/product.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
