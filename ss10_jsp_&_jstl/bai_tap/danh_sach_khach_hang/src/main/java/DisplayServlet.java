import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayServlet", urlPatterns = "/display")
public class DisplayServlet extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        customerList.add(new Customer("Giang","12-12-1999","Huế","https://meta.vn/Data/image/2021/08/03/anh-anime-buon-2.jpg"));
        customerList.add(new Customer("Hoàng","12-12-1991","Đà Nẵng","https://meta.vn/Data/image/2021/08/03/anh-anime-buon-2.jpg"));
        customerList.add(new Customer("Long","12-12-1994","Quảng Bình","https://meta.vn/Data/image/2021/08/03/anh-anime-buon-2.jpg"));
        customerList.add(new Customer("Tín","12-12-1995","Pháp","https://meta.vn/Data/image/2021/08/03/anh-anime-buon-2.jpg"));
        customerList.add(new Customer("An","12-12-2001","Mỹ","https://meta.vn/Data/image/2021/08/03/anh-anime-buon-2.jpg"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("customers",customerList);
        request.getRequestDispatcher("display.jsp").forward(request,response);
    }
}
