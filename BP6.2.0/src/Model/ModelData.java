package Model;

import AStar.Node;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;

public class ModelData {

    public static int currentX;
    public static int currentY;
    public static int nextX;
    public static int nextY;
    public static int testCount = 0;
    public static String richting = "noord";
    public static int[][] routeArray= new int[][]{};
    public static ArrayList<Node> routeList = new ArrayList<>();
    public static ArrayList<Node> blocksArray= new ArrayList<>();
    public static int offset = 1;
    public static int status = 0;
    public static String whiles = "Start";
    public static int sRow = 0;
    public static int sCol = 0;

    public static int getTestCount() {
        return testCount;
    }

    public static void setTestCount(int testCount) {
        ModelData.testCount = testCount;
    }

    public static int getsRow() { return sRow; }

    public static void setsRow(int sRow) { ModelData.sRow = sRow; }

    public static int getsCol() { return sCol; }

    public static void setsCol(int sCol) { ModelData.sCol = sCol; }

    public static String getWhiles() {
        return whiles;
    }

    public static void setWhiles(String whiles) {
        ModelData.whiles = whiles;
    }

    public static ArrayList<Node> getBlocksArray() {
        return blocksArray;
    }

    public static void setBlocksArray(ArrayList<Node> blocksArray) {
        ModelData.blocksArray = blocksArray;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        ModelData.status = status;
    }

    public static int getOffset() {
        return offset;
    }

    public static void setOffset(int offset) {
        ModelData.offset = offset;
    }

    public static int getCurrentX() {
        return currentX;
    }

    public static void setCurrentX(int currentX) {
        ModelData.currentX = currentX;
    }

    public static int getCurrentY() {
        return currentY;
    }

    public static void setCurrentY(int currentY) {
        ModelData.currentY = currentY;
    }

    public static int getNextX() {
        return nextX;
    }

    public static void setNextX(int nextX) {
        ModelData.nextX = nextX;
    }

    public static int getNextY() {
        return nextY;
    }

    public static void setNextY(int nextY) {
        ModelData.nextY = nextY;
    }

    public static String getRichting() {
        return richting;
    }

    public static void setRichting(String richting) {
        ModelData.richting = richting;
    }

    public static int[][] getRouteArray() {
        return routeArray;
    }

    public static void setRouteArray(int[][] routeArray) {
        ModelData.routeArray = routeArray;
    }

    public static ArrayList<Node> getRouteList() {
        return routeList;
    }

    public static void setRouteList(ArrayList<Node> routeList) {
        ModelData.routeList = routeList;
    }
}