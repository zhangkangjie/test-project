import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("----- "+Thread.currentThread().getName()+"-------- servlet doGet  --------");
        resp.getWriter().print("ok");

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("----- "+Thread.currentThread().getName()+"-------- servlet service 1 --------");
        super.service(req, res);
        System.out.println("----- "+Thread.currentThread().getName()+"-------- servlet service 2 --------");
        //res.getWriter().print("ok");
    }
}
