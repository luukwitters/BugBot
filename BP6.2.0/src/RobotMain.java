//import Controller.Test;
import AStar.CalcRoute;
import AStar.Node;
import Controller.MoveController;
import Model.BoebotModel;
import Model.ModelData;
import TI.BoeBot;
import TI.PinMode;
import TI.Servo;
import sun.awt.image.ImageWatched;

public class RobotMain {
    //    public static String API = "https://bp6.adainforma.tk/helloworldbot/functions/datalayer/api/test/?selector=ae026dd58cd57fd2&validator=4424bdd85905aa88646327911b6893598a279abb4f82466dca61a988041afb08&action=put&row=" + ix + "&column=" + iy + "&direction="  + richting;
    public static Servo Rechts = new Servo(12);
    public static Servo Links = new Servo(13);


    public static void main(String[] args) {
        System.out.println("Even wachten");
        BoeBot.digitalWrite(11, false);
        BoeBot.digitalWrite(2, false);
        BoeBot.wait(5000);
        CalcRoute.calcRoute();
//        MoveController moveController = new MoveController();
//        moveController.checkObstacles(ModelData.getBlocksArray(),new Node(1,3), 0);
//        Controller.MoveController.forward(Links, Rechts);
//        System.out.println("moving");
//        ModelData.setCurrentX(0);
//        ModelData.setCurrentY(0);
//
//        CalcRoute.calcRoute();

        while (true){

            if(ModelData.getWhiles() == "Start") {
                Controller.MoveController.lineFollow(Links, Rechts);
//                Controller.MoveController.detectObstacle(Links, Rechts);
            }

            else if (ModelData.getWhiles() == "Standby") {
//                MoveController.knipper();

            }
        }

//

//
//        while (ModelData.getWhiles() == "Test") {
//            System.out.println(ModelData.getBlocksArray().toString());
//            System.out.println(moveController.checkObstacles(ModelData.getBlocksArray(), new Node(4, 4), 0));
//            BoeBot.wait(1000);
//            System.out.println(ModelData.getBlocksArray().toString());
//            ModelData.setWhiles("Stop");
//        }
//
//        while (ModelData.getWhiles() == "Diagnose") {
//            MoveController.diagnose(Links, Rechts);
//        }
//
//    }

//    static void mainCaller() {
//        if(ModelData.getWhiles() != "Stop"){
//            main(null);
//        }
//
    }
}
