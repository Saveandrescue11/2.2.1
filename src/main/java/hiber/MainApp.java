package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Китай", "Рулидд", "Чина@Китай.com");
      User user2 = new User("Новая", "Зеландия", "Новая@Зеландия.com");
      User user3 = new User("Карибские", "Острова", "Карибские@Острова.com");
      User user4 = new User("Америка", "США", "Сша@Америка.com");

      Car car1 = new Car("Черри", 2010);
      Car car2 = new Car("Шиш", 1001);
      Car car3 = new Car("Лодка", 7);
      Car car4 = new Car("Тесла", 290);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      // 1. users & cars
      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println("1.Test=======================================");
      }

      // 2. by models/series
      System.out.println(userService.getUserByCar("Тесла", 290));
      System.out.println("2.Test=======================================");

      context.close();
   }
}
