
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

    private Connection con; private PreparedStatement ps;
    
    //called while loading
    public void init() {
         //String sql = "UPDATE Student SET Student_name=?,Student_DOB=?,Student_DOJ=? WHERE Student_no=?";       
        String sql = "SELECT * from Student where Student_no=?";

        try{
        //Class.forName("com.mysql.jdbc.Driver");
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata", "root", "root");
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("driver loaded");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
        ps=con.prepareStatement(sql);
       
       
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //called just before unloading
    public void destroy() {
        try{
        con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        //request-read
        //?uid=aaa%40gmail.com&password=ssi&name=abc&address=indore&mobile=9094599445
        String no = request.getParameter("STUDENT_NO");
        
        //process (store the values to DB)
        //now we will store the values into DB using jdbc
        try {
            //password=?, uname=?, email=?, address=?, mobile=?, status='enabled' WHERE userid=?";
            ps.setString(1, no);
        
           
            ResultSet rs=ps.executeQuery();
            out.println("<html>");
            out.println("<body>");
        
            out.println("<hr>");
            while(rs.next()){
                if(!rs.next())
                {
                    out.println("enter correct student_id");
                }
                  String s1=rs.getString(1);
                String s2=rs.getString(2);
                String s3=rs.getString(3);
                String s4=rs.getString(4);
                out.print("<html>");
                 out.print("<body>");
                out.println("Student id=   "+s1+"");
              
                out.println("Student name=   "+s2+"");
              
                out.println("Student dob=   "+s3+"");
              
                out.println("Student doj=   "+s4+"");
            out.println("<br>");
            }
            out.println("<hr>");
           
            out.println("<a href=index.html>HOME</a><br>");
            out.println("</body>");
            out.println("</html>");
       
        } catch (Exception e) {
            out.println(e);
            out.println("enter correct student_no");
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
