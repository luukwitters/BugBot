package AStar;

import Controller.MoveController;
import Controller.UpdateCoord;
import Model.ModelData;
import AStar.*;
import TI.Servo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.w3c.dom.NodeList;

import javax.jws.WebParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CalcRoute {

    static ArrayList<int[]> routeArray;

    public static ArrayList<Node> calcRoute() {
        Node initialNode = new Node(ModelData.getsRow(), ModelData.getsCol());
        ModelData.setCurrentX(0);
        ModelData.setCurrentY(0);
        Node finalNode = new Node(0, 3);
        int rows = 6;
        int cols = 7;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
//        int[][] blocksArray= new int[][]{{1, 3}, {2, 3}, {3, 3}};
        ArrayList<Node> blocksArray = new ArrayList();
//        blocksArray.add(new Node(1,3));
//        blocksArray.add(new Node(2,3));
//        blocksArray.add(new Node(3,3));
//        blocksArray.add(new Node(0,2));
        aStar.setBlocks(blocksArray);
        ModelData.setBlocksArray(blocksArray);
        List<Node> path = aStar.findPath();
        ArrayList<Node> routeList = new ArrayList<>();


        for (Node node : path) {
            System.out.println(node);
            routeList.add(new Node(node.getRow(), node.getCol()));
        }

        ModelData.setRouteList(routeList);
        return routeList;


//        for (Node node  : routeList)
//        {
//            System.out.println(node);
//
//        }

        //Search Area
        //      0   1   2   3   4   5   6
        // 0    -   -   -   -   -   -   -
        // 1    -   -   -   B   -   -   -
        // 2    -   -   -   B   -   -   -
        // 3    -   -   -   B   -   -   -
        // 4    -   -   -   -   -   -   -
        // 5    -   -   -   -   -   -   -

    }

    public static void driveRoute(Servo Links, Servo Rechts) {
        int turningspeed = 30;
        System.out.println("drive route");

        ArrayList<Node> routeList = ModelData.getRouteList();

        if (ModelData.getOffset() < routeList.size()) {
            ModelData.setNextX(routeList.get(ModelData.getOffset()).getRow());
            ModelData.setNextY(routeList.get(ModelData.getOffset()).getCol());

            //X-as omhoog
            if (ModelData.getCurrentX() < ModelData.getNextX()) {
                System.out.println("hier1");
                switch (ModelData.getRichting()) {
                    case "noord":
                        MoveController.turnRight(turningspeed, Links, Rechts);
                        break;
                    case "oost":
                        MoveController.forward(Links, Rechts);
                        break;
                    case "zuid":
                        MoveController.turnLeft(turningspeed, Links, Rechts);
                        break;
                    case "west":
                        System.out.println("Kan geen 180 graden draaien");
                        break;
                    default:
                        System.out.println("error");
                }
//                ModelData.setCurrentX(ModelData.getNextX());

            } else if (ModelData.getCurrentX() > ModelData.getNextX()) {
                //X-as omlaag
                System.out.println("hier2");

                switch (ModelData.getRichting()) {
                    case "noord":
                        MoveController.turnLeft(turningspeed, Links, Rechts);
                        break;
                    case "oost":
                        System.out.println("kan niet 180 graden draaien");
                        break;
                    case "zuid":
                        MoveController.turnRight(turningspeed, Links, Rechts);
                        break;
                    case "west":
                        MoveController.forward(Links, Rechts);
                        break;
                    default:
                        System.out.println("error");
                }
//                ModelData.setCurrentX(ModelData.getNextX());

            } else if (ModelData.getCurrentY() < ModelData.getNextY()) {
                //Y-as omhoog
                System.out.println("hier3");
                System.out.println(ModelData.getRichting());

                switch (ModelData.getRichting()) {
                    case "noord":
                        MoveController.forward(Links, Rechts);
                        break;
                    case "oost":
                        MoveController.turnLeft(turningspeed, Links, Rechts);
                        break;
                    case "zuid":
                        System.out.println("kan niet 180 graden draaien");
                        break;
                    case "west":
                        MoveController.turnRight(turningspeed, Links, Rechts);
                        break;
                    default:
                        System.out.println("error");
                }
//                ModelData.setCurrentY(ModelData.getNextY());

            } else if (ModelData.getCurrentY() > ModelData.getNextY()) {
                //Y-as omlaag
                System.out.println("hier4");

                switch (ModelData.getRichting()) {
                    case "noord":
                        System.out.println("kan niet 180 graden draaien");
                        break;
                    case "oost":
                        MoveController.turnRight(turningspeed, Links, Rechts);
                        break;
                    case "zuid":
                        MoveController.forward(Links, Rechts);
                        break;
                    case "west":
                        MoveController.turnLeft(turningspeed, Links, Rechts);
                        break;
                    default:
                        System.out.println("error");
                }
//                ModelData.setCurrentY(ModelData.getNextY());
            }

            ModelData.setOffset(ModelData.getOffset()+1);
            System.out.println(ModelData.getCurrentX()+","+ ModelData.getCurrentY());
            MoveController.lineFollow(Links, Rechts);
        }

        else {
            MoveController.emergencyBrake(Links, Rechts);
            System.out.println(ModelData.getCurrentX()+","+ ModelData.getCurrentY());
            System.out.println("Ik ben klaar");
            System.out.println("Whiles stoppen");
            ModelData.setWhiles("Gestopt");
            System.out.println("Whiles is " + ModelData.getWhiles());

        }
    }
}
