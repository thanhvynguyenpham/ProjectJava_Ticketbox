package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import Model.Film;
import Model.Theater;
import Model.Showtime;
import Model.Seat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * ShowtimeDAO
 */
public class ShowtimeDAO {
    public static ArrayList<Showtime> getAllShowtimesBy(Theater theater) {
        ArrayList<Showtime> show = new ArrayList<Showtime>();
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "select * from showtime where idtheater = ? ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, theater.getID());
            res = stm.executeQuery();
            while(res.next()){
                Film film= FilmDAO.searchAFilm(res.getInt("idfilm"));
                Showtime st= new Showtime(res.getInt("id"), theater, film,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return show;
    }
    public static ArrayList<Showtime> getAllShowtimesBy(String theater,String film) {
        ArrayList<Showtime> show = new ArrayList<Showtime>();
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            Theater t = TheaterDAO.searchTheater(theater);
            Film f= FilmDAO.searchAFilm(film);
            String sql = "select * from showtime where idtheater = ? and idfilm = ? ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, t.getID());
            stm.setInt(2, f.getID());
            res = stm.executeQuery();
            while(res.next()){
                Showtime st= new Showtime(res.getInt("id"), t, f,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return show;
    }
    public static ArrayList<Seat> getAllSeatsBy(int idShowtime ){
        ArrayList<Seat> seats = new ArrayList<Seat>();
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "select * from seatsofshowtime where idshowtime = ? ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, idShowtime);
            res = stm.executeQuery();
            while(res.next()){
                seats.add(new Seat(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return seats;
    }
    public static ArrayList<Showtime> getAllShowtimesBy(Film film) {
        ArrayList<Showtime> show = new ArrayList<Showtime>();
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "select * from showtime where idfilm = ? ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, film.getID());
            res = stm.executeQuery();
            while(res.next()){
                Theater theater= TheaterDAO.searchTheater(res.getInt("idtheater"));
                Showtime st= new Showtime(res.getInt("id"), theater, film,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return show;
    }
    public static boolean bookTickets(ArrayList<Seat> seats)
    {
        Connection conn = null;
        PreparedStatement stm=null;
        int res=0;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "update seatsofshowtime set status= ? where idshowtime= ? and idrow=? and idcolumn = ?";
            for (Seat seat : seats) {
                stm = conn.prepareStatement(sql);
                stm.setInt(1, seat.getStatus());
                stm.setInt(2,seat.getIDShowtime());
                stm.setInt(3,seat.getIDRow());
                stm.setInt(4,seat.getIDColumn());
                res += stm.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(res== seats.size())
            return true;
        return false;
        
    }
    public static int getReport(Theater theater) {
        int rs=0;
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "select sum(ticketprice) from seatsofshowtime as se inner join showtime as st on (se.idshowtime = st.id) where st.idtheater = ? and se.status is not null ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, theater.getID());
            res = stm.executeQuery();
            if(res.next()){
                rs=+res.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }
    public static int getReport(Film film) {
        int rs=0;
        Connection conn = null;
        PreparedStatement stm=null;
        ResultSet res=null;
        try {
            conn = JDBCConnection.getConnection();
            String sql = "select sum(ticketprice) from seatsofshowtime as se inner join showtime as st on (se.idshowtime = st.id) where st.idfilm = ? and se.status is not null ";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, film.getID());
            res = stm.executeQuery();
            if(res.next()){
                rs=+res.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }
    private static int check_existing_showtime(String startime, String date,int idtheater,Connection conn )
    {
        PreparedStatement stm=null;
        ResultSet res=null;
        int rs=-1;
        try{
            String sql = "select * from showtime where starttime like ? and date like ? and idtheater=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, startime);            
            stm.setString(2, date);
            stm.setInt(3, idtheater);
            res= stm.executeQuery();
            if(res.next()){
                rs=res.getInt("id");
            }
           

        }catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{

                if(res != null)
                    res.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }
    private static String[] generateDate(String begin,String end)
    {
        String[] beginDate= begin.split("-");
        String[] endDate= end.split("-");
        LocalDate start = LocalDate.of(Integer.parseInt(beginDate[0]), Integer.parseInt(beginDate[1]),Integer.parseInt(beginDate[2]));
        LocalDate finish = LocalDate.of(Integer.parseInt(endDate[0]), Integer.parseInt(endDate[1]),Integer.parseInt(endDate[2]));
        List<LocalDate> listOfDates = start.datesUntil(finish.plusDays(1)).collect(Collectors.toList());
        String[] date= new String[listOfDates.size()];
        for(int i=0;i<date.length;i++)
        {
            date[i]=listOfDates.get(i).format(DateTimeFormatter.ISO_LOCAL_DATE);
            
        }
        return date;

    }
    public static int addShowtimes(int idfilm,int idtheater,String starttime,String daybegin,String dayend,boolean ignore)
    {
        Connection conn = null;
        PreparedStatement stm=null;
        int res=0;
        String sql="";
        try {
            String[] listDate = generateDate(daybegin,dayend);
            conn = JDBCConnection.getConnection();
            sql = "insert into  showtime  VALUES (null,?,?,?,null,null,?)" ;    
            for (String d : listDate) {
                System.out.println(d);
                if(check_existing_showtime(starttime, d,idtheater, conn)==-1)
                {
                    stm= conn.prepareStatement(sql);
                    stm.setInt(1, idfilm);
                    stm.setInt(2,idtheater);
                    stm.setString(3, starttime);
                    stm.setString(4, d);
                    res+=stm.executeUpdate();

                }
                else
                {
                    if(ignore==false)
                    {
                    sql="update showtime set idfilm=? where id=?"    ;
                    stm= conn.prepareStatement(sql);
                    stm.setInt(2, idfilm);
                    stm.setInt(1,check_existing_showtime(starttime, d,idtheater, conn) );
                    res+=stm.executeUpdate();
                    }
                }
            }            

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                if(conn != null)
                    conn.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
    public static int deleteAShowtime(int idshowtime){
        int res=0;
        PreparedStatement stm=null;
        Connection con=null;
        try{
            con=JDBCConnection.getConnection();
            String sql="delete from showtime  where id = ?";
            stm= con.prepareStatement(sql);
            stm.setInt(1, idshowtime);
            res += stm.executeUpdate();

        }catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{

                if(con!=null)
                    con.close();
                if(stm != null)
                    stm.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }
    public static ArrayList<Showtime >getAllShowtimeBy(int idtheater,int idfilm,String date){
        ArrayList<Showtime> show=new ArrayList<Showtime>();
        Connection con=null;
        PreparedStatement stm = null;
        ResultSet res=null;
        try{
            con= JDBCConnection.getConnection();
            Theater t= TheaterDAO.searchTheater(idtheater);
            Film f = FilmDAO.searchAFilm(idfilm);
            String sql = "select * from showtime where idtheater = ? and idfilm=? and date like ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1,idtheater);
            stm.setInt(2,idfilm);
            stm.setString(3,date);
            res= stm.executeQuery();
            while(res.next()){
                Showtime st= new Showtime(res.getInt("id"), t, f,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        }catch(SQLException ex)
        {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(con!= null)
                    con.close();
                if(stm!= null)
                    stm.close();
                if(res!=null)
                    res.close();
            }catch(SQLException ex)
                {ex.printStackTrace();}
        }
        return show;
    }
    public static ArrayList<Showtime >getAllShowtimeByTheater(int idtheater,String date){
        ArrayList<Showtime> show=new ArrayList<Showtime>();
        Connection con=null;
        PreparedStatement stm = null;
        ResultSet res=null;
        try{
            con= JDBCConnection.getConnection();
            Theater t= TheaterDAO.searchTheater(idtheater);
            String sql = "select * from showtime where idtheater = ? and date like ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1,idtheater);
            stm.setString(2,date);
            res= stm.executeQuery();
            while(res.next()){
                Film f = FilmDAO.searchAFilm(res.getInt("idfilm"));
                Showtime st= new Showtime(res.getInt("id"), t, f,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        }catch(SQLException ex)
        {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(con!= null)
                    con.close();
                if(stm!= null)
                    stm.close();
                if(res!=null)
                    res.close();
            }catch(SQLException ex)
                {ex.printStackTrace();}
        }
        return show;
    }
    public static ArrayList<Showtime >getAllShowtimeByFilm(int idfilm,String date){
        ArrayList<Showtime> show=new ArrayList<Showtime>();
        Connection con=null;
        PreparedStatement stm = null;
        ResultSet res=null;
        try{
            con= JDBCConnection.getConnection();
            Film f = FilmDAO.searchAFilm(idfilm);
            String sql = "select * from showtime where idfilm = ? and date like ?";
            stm = con.prepareStatement(sql);
            stm.setInt(1,idfilm);
            stm.setString(2,date);
            res= stm.executeQuery();
            while(res.next()){
                Theater t = TheaterDAO.searchTheater(res.getInt("idtheater"));
                Showtime st= new Showtime(res.getInt("id"), t, f,res.getString("starttime"));
                ArrayList<Seat> seats = ShowtimeDAO.getAllSeatsBy(st.getID());
                st.setSeats(seats);
                show.add(st);
            }

        }catch(SQLException ex)
        {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(con!= null)
                    con.close();
                if(stm!= null)
                    stm.close();
                if(res!=null)
                    res.close();
            }catch(SQLException ex)
                {ex.printStackTrace();}
        }
        return show;
    }
    public static int[] getRevenue(int idfilm,int idtheater,String starttime,String beginday,String endday){
        int rs[]= {0,0,0};
        Connection con = null;
        PreparedStatement stm=null;
        PreparedStatement stm1=null;

        ResultSet res=null;
        ResultSet res1=null;
        try{
            con = JDBCConnection.getConnection();
            String sql = "select count(*),sum(ticketprice)  from seatsofshowtime as se inner join showtime as st on (se.idshowtime = st.id) where se.status is not null and date like ? ";       
            String sql1 = "select count(distinct se.idshowtime)  from seatsofshowtime as se inner join showtime as st on (se.idshowtime = st.id) where  date like ? ";
            if (idfilm != -1)
            {   sql+=" and idfilm = ?";
                sql1+=" and idfilm = ?";
            }
            if(idtheater !=-1)
            {
                sql +=" and idtheater = ?";
                sql1 +=" and idtheater = ?";
            }
            if(starttime !=null)
            {
                sql += "  and starttime like ?";
                sql1 += "  and starttime like ?";
            }
            int count=2;
            String[] date = generateDate(beginday, endday);
            stm = con.prepareStatement(sql);
            stm1 = con.prepareStatement(sql1);

            if (idfilm != -1)
            {
                stm.setInt(count,idfilm);
                stm1.setInt(count,idfilm);
                count++;
            }
            if(idtheater !=-1)
            {
                stm.setInt(count,idtheater);
                stm1.setInt(count,idtheater);
                count++;
            }
            if(starttime !=null)
            {
                stm.setString(count, starttime);
                stm1.setString(count, starttime);
                count++;
            }
            System.out.println(sql);

            for (String d : date) {
                stm.setString(1, d);
                stm1.setString(1, d);
                res= stm.executeQuery();
                res1=stm1.executeQuery();
                if(res.next() && res1.next())
                {
                    rs[0]+=res.getInt(1);
                    rs[2]+=res.getInt(2);
                    rs[1]+=res1.getInt(1)*40;
                }                
            }   
                
        }catch(SQLException ex)
        {       
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    finally{
        try{
            if(con!= null)
                con.close();
            if(stm!= null)
                stm.close();

        }catch(SQLException ex)
            {ex.printStackTrace();}
    }
        return rs;
    }
    
    public static void main(String[] args){
        int[] rs = ShowtimeDAO.getRevenue(10005, -1, null, "2021-01-01", "2021-01-02");
        for (int i : rs) {
            System.out.println(i);
        }
 
        
    }
}