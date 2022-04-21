package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createProduct(request, response);
                break;
            case "edit":
//                updateProduct(request, response);
                break;
            case "delete":
//                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                showCreateForm(request, response);
                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "search":
//                searchProduct(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {

    }
}
