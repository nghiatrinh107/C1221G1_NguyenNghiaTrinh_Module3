package controller;

import model.customer.Customer;
import model.customer.CustomerType;
import model.furama_service.FuramaService;
import model.furama_service.RentType;
import model.furama_service.ServiceType;
import service.IFuramaServiceService;
import service.IRentTypeService;
import service.IServiceType;
import service.impl.furama_service.FuramaServiceImpl;
import service.impl.furama_service.RentTypeServiceImpl;
import service.impl.furama_service.ServiceTypeImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FuramaServiceController", urlPatterns = {"/service"})
public class FuramaServiceController extends HttpServlet {
    private IFuramaServiceService iFuramaService = new FuramaServiceImpl();
    private IRentTypeService iRentTypeService = new RentTypeServiceImpl();
    private IServiceType iServiceType = new ServiceTypeImpl();

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
                create(request, response);
                break;
            default:
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String serviceName = request.getParameter("name");
        Integer serviceArea = Integer.valueOf(request.getParameter("area"));
        Integer serviceCost = Integer.valueOf(request.getParameter("cost"));
        Integer serviceMaxPeople = Integer.valueOf(request.getParameter("people"));
        Integer rentType = Integer.valueOf(request.getParameter("rent"));
        Integer serviceType = Integer.valueOf(request.getParameter("service_type"));
        String standardRoom = request.getParameter("room");
        String description = request.getParameter("description");
        Integer poolArea = Integer.valueOf(request.getParameter("pool"));
        Integer numberOfFloors = Integer.valueOf(request.getParameter("floors"));
        FuramaService furamaService = new FuramaService(serviceName,serviceArea,serviceCost,serviceMaxPeople,rentType,serviceType,standardRoom,description,poolArea,numberOfFloors);
        Map<String,String> map = iFuramaService.save(furamaService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/furama_service/create.jsp");
        request.setAttribute("message", "New service was created");
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
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/furama_service/create.jsp");
        List<RentType> rentTypeList = iRentTypeService.getRentType();
        request.setAttribute("type", rentTypeList);
        List<ServiceType> serviceTypeList = iServiceType.getServiceType();
        request.setAttribute("service_type", serviceTypeList);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<FuramaService> furamaServiceList = iFuramaService.getList();
        request.setAttribute("service", furamaServiceList);
        List<RentType> rentTypeList = iRentTypeService.getRentType();
        request.setAttribute("type", rentTypeList);
        List<ServiceType> serviceTypeList = iServiceType.getServiceType();
        request.setAttribute("service_type", serviceTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/furama_service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
