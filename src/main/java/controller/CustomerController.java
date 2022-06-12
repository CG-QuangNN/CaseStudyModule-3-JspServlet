package controller;

import model.Customer;
import service.ICustomerService;
import service.IFindAllService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "CustomerController", value = "/customer")
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICustomerService customerService;
    private IFindAllService customerTypeService;

    public void init() {
        customerService = new CustomerService();
        customerTypeService = new CustomerTypeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
//                case "edit":
//                    showEditForm(request, response);
//                    break;
//                case "delete":
//                    deleteUser(request, response);
//                    break;
                default:
                    list(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        request.setAttribute("customerList", customerService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("customerTypeList", customerTypeService.findAll());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    create(request, response);
                    break;
                case "edit":
//                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        Customer customer = Customer.builder()
                .customerCode(request.getParameter("customer_code"))
                .customerTypeId(Integer.parseInt(request.getParameter("customer_type_id")))
                .customerName(request.getParameter("customer_name"))
                .customerBirthday(LocalDate.parse(request.getParameter("customer_birthday")))
                .customerGender(Boolean.parseBoolean(request.getParameter("customer_gender")))
                .customerIdCard(request.getParameter("customer_id_card"))
                .customerPhone(request.getParameter("customer_phone"))
                .customerEmail(request.getParameter("customer_email"))
                .customerAddress(request.getParameter("customer_address"))
                .build();

        customerService.create(customer);

        response.sendRedirect("customer");
    }

    public static void main(String[] args) {
        String []abc = {"123"};
    }
}
