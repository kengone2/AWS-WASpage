import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // JDBC 연결 정보
        String jdbcURL = "jdbc:mysql://mysql-database-1.cdcae66o2aab.ap-northeast-2.rds.amazonaws.com:3306/mysql-database-1";
        String dbUser = "kengoe";
        String dbPassword = "12345678";

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.jdbc.Driver");
            // 데이터베이스에 연결
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            // INSERT 쿼리 작성
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            // 쿼리 실행
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            // 연결 종료
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
