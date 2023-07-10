package pl.horus;

public class HorusApp {
    public static void main(String[] args) {

        Wall wall = new Wall();
        Wall wallTwo = new Wall();

        wallTwo.addBlock(new Block("black", "carbon"));
        wallTwo.addBlock(new Block("green", "grass"));

        wall.addBlock(new Block("yellow", "stone"));
        wall.addBlock(new Block("black", "carbon"));
        wall.addBlock(new Block("blue", "plastic"));
        wall.addBlock(new Block("silver", "steel"));

        System.out.println("Wall list: " + wall.blocks);
        System.out.println("Wall size: " + wall.count());

        System.out.println("WallTwo list: " + wallTwo.blocks);
        System.out.println("WallTwo size: " + wallTwo.count());

        System.out.println("Found by color in wall: " + wall.findBlockByColor("blue").toString());
        System.out.println("Found by material in wall: " + wall.findBlocksByMaterial("carbon").toString());


    }
}