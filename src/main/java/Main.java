import model.ClassList;
import model.UserList;

import java.sql.Connection;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBUtils.connect();
        Scanner sc = new Scanner(System.in);
        DBUtils db= new DBUtils();

        System.out.println("Enter you Username: ");
        String email = sc.next();

        System.out.println("Enter you Password: ");
        String password = sc.next();
        boolean bool=db.loginDatabase(connection,email,password);
        UserList ul=new UserList();
        ClassList cl=new ClassList();
        if (email.equalsIgnoreCase("admin") && (password.equalsIgnoreCase("adminhero"))) {
            while(true){
                System.out.println("please choose one (1/2/3/4/5)");
                System.out.println("1. Add User");
                System.out.println("2. View User list");
                System.out.println("3. Add Class");
                System.out.println("4. View Class list");
                System.out.println("5. Log out");
                String selection=sc.next();

                if(selection.equals("1")){
                    ul.enteruser();
                    db.insert_user(connection,ul.getUsername(), ul.getPassword());
                }
                else if(selection.equals("2")){
                    List<UserList> new_UserList=DBUtils.getAllUsers(connection);

                    System.out.println("| ID |       User Name        |     Password   |");


                    for(UserList b:new_UserList){
                        System.out.printf("| | |  |\n", b.getId(), b.getUsername(), b.getPassword());


                    } System.out.println("************************************************");

                }else if(selection.equals("3")){
                    cl.populate_class();
                    db.insert_class(connection,cl.getClassname());
                }else if(selection.equals("4")){
                    List<ClassList> new_ClassList=DBUtils.getAllClass(connection);

                    System.out.println("| ID |       Class Name       |");


                    for(ClassList b:new_ClassList){
                        System.out.printf("|  |  |\n", b.getId(), b.getClassname());


                    } System.out.println("************************************************");
                }else if(selection.equals("5")){
                    break;
                }


            }

        } else if(bool){
            int user_id=db.get_id(connection,email);
            List<ClassList> new_ClassList=DBUtils.getAllClass(connection);

            System.out.println("| ID |       Class Name       |");


            for(ClassList b:new_ClassList){
                System.out.printf("|  | |\n", b.getId(), b.getClassname());


            } System.out.println("****************************************************************");

            System.out.println("\n\n Enter class id:");
            int class_id=sc.nextInt();
            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            db.insert_attendance(connection,class_id,user_id,date);



        }else{
            System.out.println("wrong Credentials");
        }

    }

}
