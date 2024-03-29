import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet") // URL 패턴 지정
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 입력한 아이디와 패스워드 받기
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 여기에서 받은 아이디와 패스워드를 데이터베이스와 비교하여 로그인 처리를 진행합니다.

        // 예시: 사용자가 admin이고 패스워드가 1234일 때 로그인 성공 처리
        if ("admin".equals(username) && "1234".equals(password)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login Successful!</h2>");
            out.println("</body></html>");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login Failed. Please check your username and password.</h2>");
            out.println("</body></html>");
        }
    }
}
