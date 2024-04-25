package vista;

import dao.ServidorDAO;
import model.Series;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Series serie1 = new Series();
        serie1.setName("Fallout");
        serie1.setReleased(LocalDate.now());
        try {
            ServidorDAO.transaction();
            ServidorDAO.create(serie1, false);
//            ServidorDAO.create(serie2, false);
//            ServidorDAO.create(serie3, false);
//            ServidorDAO.create(serie4, false);
//            ServidorDAO.create(serie5, false);
            ServidorDAO.commit();
            System.out.println(ServidorDAO.readObject("FROM Series WHERE id = " + serie1.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Hi Nworld !!");
    }
}
