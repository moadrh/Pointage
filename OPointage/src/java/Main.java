
import java.util.ArrayList;
import java.util.List;
import services.PointagecompletService;
import services.PointageService;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//         HibernateUtil.getSessionFactory().openSession();
        
        PointageService ps = new PointageService();
//        System.out.println("pp " + ps.totalHeurebyYear(1, 2018));
//        System.out.println(" "+ ps.totalHeure());
//        PointagecompletService pcs = new PointagecompletService();
//        System.out.println("fhuuu" + pcs.historiqueByEmploye(1));
List<Integer> mList4 = new ArrayList<Integer>();
          mList4.add(2011);
          mList4.add(2012);
          mList4.add(2013);
          mList4.add(2014);
          mList4.add(2015);
          mList4.add(2016);
          mList4.add(2017);
          mList4.add(2018);
          mList4.add(2019);
          List<Integer> mList42 = new ArrayList<Integer>();
          for(int m :mList4){
              mList42.add(ps.totalHeurebyYear(1, m)) ;
          }
          System.out.println(mList42);
    }
    

}
