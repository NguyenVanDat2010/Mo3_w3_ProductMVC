package product.controller;

import product.model.Product;
import product.service.IProductService;
import product.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.productService.delete(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setProductName(name);
            product.setDescription(description);
            product.setProductPrice(price);

            this.productService.update(id, product);
            request.setAttribute("message", "Product information was updated");

            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = (int) (Math.random() * 10000);

        Product product = new Product(id, name, description, price);
        this.productService.save(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//--------------------------------------------------------------------------------------------------------------


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
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                showViewProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList= this.productService.findAll();
        request.setAttribute("products",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            /** Hiển thị các dữ liệu bản ghi ra form "view.jsp" */
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            /** Hiển thị các dữ liệu bản ghi ra form "delete.jsp" của id cần xóa */
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);

        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            /** Hiển thị các dữ liệu bản ghi ra form "edit.jsp" của id cần sửa */
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
