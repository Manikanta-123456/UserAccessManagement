@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate credentials
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yourdb", "user", "password")) {
            String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, username);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    if ("Employee".equals(role)) {
                        response.sendRedirect("requestAccess.jsp");
                    } else if ("Manager".equals(role)) {
                        response.sendRedirect("pendingRequests.jsp");
                    } else if ("Admin".equals(role)) {
                        response.sendRedirect("createSoftware.jsp");
                    }
                } else {
                    response.sendRedirect("login.jsp?error=true");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
