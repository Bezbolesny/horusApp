package pl.horus;

import pl.horus.interfaces.CompositeBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Block implements CompositeBlock {

    private String color;
    private String material;
    private List<pl.horus.interfaces.Block> blockList = new ArrayList<>();

    public Block(String color, String material){
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<pl.horus.interfaces.Block> getBlocks() {
        return blockList;
    }

    @Override
    public String toString(){
        return getColor() + " " + getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return Objects.equals(color, block.color) && Objects.equals(material, block.material) && Objects.equals(blockList, block.blockList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, material, blockList);
    }
}
