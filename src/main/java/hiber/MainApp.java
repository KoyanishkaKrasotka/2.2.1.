package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);



      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      User user5 = new User("User5", "Lastname5", "user5@mail.ru");
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);
      Car car1 = new Car("Bmw", 1, user1);
      Car car2 = new Car("Mersedes", 2, user2);
      Car car3 = new Car("Audi", 3, user3);
      Car car4 = new Car("Lada", 4, user4);
      Car car5 = new Car("Shkoda", 5, user5);
      carService.addCar(car1);
      carService.addCar(car2);
      carService.addCar(car3);
      carService.addCar(car4);
      carService.addCar(car5);
      System.out.println(userService.findUserByCarModelAndSeries("Lada", 4));
      System.out.println(userService.findUserByCarModelAndSeries("Shkoda", 5));
      System.out.println(userService.findUserByCarModelAndSeries("Bmw", 1));



      context.close();
   }
}
