package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerController",urlPatterns = {"/customer"})
public class CustomerController extends HttpServlet {
private ICustomerService iCustomerService = new CustomerServiceImpl();
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
                createProduct(request, response);
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


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        Integer type = Integer.valueOf(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
            Customer customer = new Customer(type,name,birthday,gender,idCard,phone,email,address);
        Map<String, String> map = iCustomerService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New user was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
//                searchProduct(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", customer);
        List<CustomerType>customerTypeList = iCustomerService.getTypeList();
        request.setAttribute("type",customerTypeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        List<CustomerType>customerTypeList = iCustomerService.getTypeList();
        request.setAttribute("type",customerTypeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer>customerList = iCustomerService.getList();
        List<CustomerType>customerTypeList = iCustomerService.getTypeList();
        request.setAttribute("type",customerTypeList);
        request.setAttribute("customer", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
