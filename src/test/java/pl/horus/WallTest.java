package pl.horus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Wall wall = new Wall();

    @BeforeEach
    public void initializeList() {
        wall.addBlock(new Block("yellow", "stone"));
        wall.addBlock(new Block("black", "carbon"));
        wall.addBlock(new Block("blue", "plastic"));
        wall.addBlock(new Block("silver", "steel"));
    }

    @Test
    public void findBlockByColorHappyPath() {
        // when
        Optional<pl.horus.interfaces.Block> blockFoundedByColor = wall.findBlockByColor("yellow");

        // then
        assertEquals(Optional.of(new Block("yellow", "stone")), blockFoundedByColor);
    }

    @Test
    public void findBlockByColorExist(){
        // when
        Optional<pl.horus.interfaces.Block> blockFoundedByColor = wall.findBlockByColor("blue");

        // then
        assertTrue(blockFoundedByColor.isPresent());

    }

    @Test
    public void findBlockByColorUnhappyPath() {
        // when
        Optional<pl.horus.interfaces.Block> blockFoundedByColor = wall.findBlockByColor("gray");

        // then
        assertNotEquals(new Block("blue", "plastic"), blockFoundedByColor);

    }

    @Test
    public void findBlockByColorDoesntExist() {
        // when
        Optional<pl.horus.interfaces.Block> blockFoundedByColor = wall.findBlockByColor("white");

        // then
        assertFalse(blockFoundedByColor.isPresent());

    }

    @Test
    public void findBlocksByMaterialHappyPath(){
        // when
        List<pl.horus.interfaces.Block> blocksFoundedByMaterial = wall.findBlocksByMaterial("PLASTIC");

        // then
        assertEquals(List.of(new Block("blue", "plastic")), blocksFoundedByMaterial);

    }

    @Test
    public void findBlocksByMaterialExist(){
        // when
        List<pl.horus.interfaces.Block> blocksFoundedByMaterial = wall.findBlocksByMaterial("Steel");

        // then
        assertTrue(!blocksFoundedByMaterial.isEmpty());

    }

    @Test
    public void findBlocksByMaterialUnhappyPath(){
        //given
        List<pl.horus.interfaces.Block> expectedBlocks = new ArrayList<>(List.of(new Block("yellow", "stone"), new Block("blue", "stone")));

        // when
        List<pl.horus.interfaces.Block> blocksFoundedByMaterial = wall.findBlocksByMaterial("stone");

        // then
        assertNotEquals(expectedBlocks, blocksFoundedByMaterial);

    }

    @Test
    public void findBlocksByMaterialDoesntExist(){
        //given
        List<pl.horus.interfaces.Block> expectedBlocks = new ArrayList<>(List.of(new Block("yellow", "stone"), new Block("blue", "stone")));

        // when
        List<pl.horus.interfaces.Block> blocksFoundedByMaterial = wall.findBlocksByMaterial("glass");

        // then
        assertTrue(blocksFoundedByMaterial.isEmpty());

    }

    @Test
    public void referencesToTheSameObjectShouldBeEqual() {
        //given
        Block blockOne = new Block("blue", "plastic");
        Block blockTwo = blockOne;

        // then
        assertSame(blockOne, blockTwo);

    }

    @Test
    public void referencesToTheSameObjectShouldNotBeEqual() {
        // given
        Block blockOne = new Block("blue", "plastic");
        Block blockTwo = new Block("gray", "plastic");

        // then
        assertNotSame(blockOne, blockTwo);

    }

    @Test
    public void twoBlocksShouldBeEqualWhenColorAndMaterialAreTheSame() {
        Block blockOne = new Block("blue", "plastic");
        Block blockTwo = new Block("blue", "plastic");

        // then
        assertEquals(blockOne, blockTwo);

    }

}