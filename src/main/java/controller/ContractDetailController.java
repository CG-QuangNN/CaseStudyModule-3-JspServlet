package controller;

import dto.ContractDetailCreateResponseDto;
import model.ContractDetail;
import service.IContractDetailService;
import service.impl.ContractDetailService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ContractDetailController", value = "/contract-detail")
public class ContractDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IContractDetailService contractDetailService;

    public void init() {
        contractDetailService = new ContractDetailService();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("contractDetail/create.jsp");

        ContractDetailCreateResponseDto contractDetailCreateResponseDto = ContractDetailCreateResponseDto.builder()
                .contractIdList(contractDetailService.findAllContractIdList())
                .attachServiceIdList(contractDetailService.findAllAttachServiceIdList())
                .build();

        request.setAttribute("contractDetailCreateResponseDto", contractDetailCreateResponseDto);
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

        ContractDetail contractDetail = ContractDetail.builder()
                .contractId(Integer.parseInt(request.getParameter("contract_id")))
                .attachServiceId(Integer.parseInt(request.getParameter("attach_service_id")))
                .quantity(Integer.parseInt(request.getParameter("quantity")))
                .build();

        contractDetailService.create(contractDetail);

        response.sendRedirect("customer");
    }
}
