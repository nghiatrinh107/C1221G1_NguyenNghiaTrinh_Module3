package controller;

import model.customer.Customer;
import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.IEducationDegreeRepository;
import service.IDivisionService;
import service.IEducationDegreeService;
import service.IEmployeeService;
import service.IPositionService;
import service.impl.employee.DivisionService;
import service.impl.employee.EducationDegreeService;
import service.impl.employee.EmployeeServiceImpl;
import service.impl.employee.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeController", urlPatterns = {"/employee"})
public class EmployeeController extends HttpServlet {
    IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    IDivisionService iDivisionService = new DivisionService();
    IEducationDegreeService iEducationDegreeService = new EducationDegreeService();
    IPositionService iPositionService = new PositionService();

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
                updateProduct(request, response);
                break;
            case "delete":
//                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
//        Integer id= Integer.parseInt(request.getParameter("id"));
//        Integer type = Integer.valueOf(request.getParameter("type_customer"));
//        String name = request.getParameter("name");
//        String date = request.getParameter("date");
//        Integer gender = Integer.parseInt(request.getParameter("gender"));
//        String cmnd=request.getParameter("cmnd");
//        String sdt=request.getParameter("sdt");
//        String email=request.getParameter("email");
//        String dia_chi=request.getParameter("dia_chi");
//        RequestDispatcher requestDispatcher;
//        Customer customer = new Customer(id,type,name,date,gender,cmnd,sdt,email,dia_chi);
//        boolean check = iCustomerService.update(customer);
//        if (check) {
//            request.setAttribute("mess", "done");
//        } else {
//            request.setAttribute("mess", "not");
//        }
//        requestDispatcher = request.getRequestDispatcher("/view/customer/edit.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        String employeeName = request.getParameter("name");
        String employeeBirthday = request.getParameter("birthday");
        String employeeIdCard = request.getParameter("idCard");
        Integer salary = Integer.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer position = Integer.valueOf(request.getParameter("position"));
        Integer educationDegree = Integer.valueOf(request.getParameter("degree"));
        Integer division = Integer.valueOf(request.getParameter("division"));
        Employee employee = new Employee(employeeName,employeeBirthday,employeeIdCard,salary,phone,email,address,position,educationDegree,division);
        Map<String,String> map = iEmployeeService.save(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        request.setAttribute("message", "New employee was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
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
        Integer id = Integer.valueOf(request.getParameter("id"));
        Employee employee = iEmployeeService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        request.setAttribute("employee", employee);
        List<Position> positionList = iPositionService.getPosition();
        request.setAttribute("position", positionList);
        List<Division> divisionList = iDivisionService.getDivisionList();
        request.setAttribute("division", divisionList);
        List<EducationDegree> educationDegreeList = iEducationDegreeService.getEducationDegree();
        request.setAttribute("degree", educationDegreeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        List<Position> positionList = iPositionService.getPosition();
        request.setAttribute("position", positionList);
        List<Division> divisionList = iDivisionService.getDivisionList();
        request.setAttribute("division", divisionList);
        List<EducationDegree> educationDegreeList = iEducationDegreeService.getEducationDegree();
        request.setAttribute("degree", educationDegreeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.getList();
        request.setAttribute("employee", employeeList);
        List<Position> positionList = iPositionService.getPosition();
        request.setAttribute("position", positionList);
        List<Division> divisionList = iDivisionService.getDivisionList();
        request.setAttribute("division", divisionList);
        List<EducationDegree> educationDegreeList = iEducationDegreeService.getEducationDegree();
        request.setAttribute("degree", educationDegreeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
