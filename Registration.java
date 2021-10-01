
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {

    private Connection con; private PreparedStatement ps;
    
    //called while loading
    public void init() {
        
        String sql = "INSERT INTO Student VALUES(?,?,?,?)";
        try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
        ps=con.prepareStatement(sql);            
            
        }catch(Exception e){}

    }

    //called just before unloading
    public void destroy() {
        /*
        try{
        con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        */
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        //request-read
        //?uid=aaa%40gmail.com&password=ssi&name=abc&address=indore&mobile=9094599445
        String STUDENT_NO = request.getParameter("STUDENT_NO");
        String  STUDENT_NAME= request.getParameter("STUDENT_NAME");
        String STUDENT_DOB = request.getParameter("STUDENT_DOB");
        String STUDENT_DOJ = request.getParameter("STUDENT_DOJ");
      
        //process (store the values to DB)
        //now we will store the values into DB using jdbc
        try {
            ps.setString(1, STUDENT_NO);
            ps.setString(2, STUDENT_NAME );
            ps.setString(3, STUDENT_DOB);
            ps.setString(4, STUDENT_DOJ);
            
            ps.executeUpdate();
         
            //response
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>Registered-Successfully</h3>");
            out.println("<h4><a href=index.html>Home</a></h4>");
            //out.println("<h4><a href=update>update</a><h4>");
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

