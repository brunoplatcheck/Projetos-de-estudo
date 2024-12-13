@WebServlet("/buscarDados")
public class BuscarDadosServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comboBoxValue = request.getParameter("comboBox");
        String textInputValue = request.getParameter("textInput");

        try {
            // Conexão com o banco de dados
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "usuario", "senha");

            // Monta a query com base na seleção do comboBox
            String query = "SELECT * FROM tabela WHERE " + comboBoxValue + " LIKE ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, "%" + textInputValue + "%");

            ResultSet rs = stmt.executeQuery();
            
            // Aqui você pode processar os resultados, por exemplo, enviá-los de volta à página JSP
            while (rs.next()) {
                // Exemplo de como exibir resultados
                response.getWriter().println(rs.getString("nome"));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao acessar o banco de dados.");
        }
    }
}
