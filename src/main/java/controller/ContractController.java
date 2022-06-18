package controller;

import dto.ContractCreateResponseDto;
import model.Contract;
import service.IContractService;
import service.impl.ContractService;
import util.LocalDateTimeUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ContractController", value = "/contract")
public class ContractController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IContractService contractService;

    public void init() {
        contractService = new ContractService();
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
//                    list(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/create.jsp");

        ContractCreateResponseDto contractCreateResponseDto = ContractCreateResponseDto.builder()
                .employeeIdList(contractService.findAllEmployeeId())
                .customerIdList(contractService.findAllCustomerId())
                .serviceIdCodeDtoList(contractService.findAllServiceIdCode())
                .build();

        request.setAttribute("contractCreateResponseDto", contractCreateResponseDto);
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
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Contract contract = Contract.builder()
                .contractStartDate(LocalDateTimeUtil.parseDateTime(request.getParameter("contract_start_date")))
                .contractEndDate(LocalDateTimeUtil.parseDateTime(request.getParameter("contract_end_date")))
                .contractDeposit(Double.parseDouble(request.getParameter("contract_deposit")))
                .contractTotalMoney(Double.parseDouble(request.getParameter("contract_total_money")))
                .employeeId(Integer.parseInt(request.getParameter("employee_id")))
                .customerId(Integer.parseInt(request.getParameter("customer_id")))
                .serviceId(Integer.parseInt(request.getParameter("service_id")))
                .build();

        contractService.create(contract);

        response.sendRedirect("customer");
    }
}
