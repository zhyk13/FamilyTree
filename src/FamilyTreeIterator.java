import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private int currentId = 0;
    private List<Human> familyTree;
    public FamilyTreeIterator() {
        this.familyTree = familyTree;
    }


    @Override
    public boolean hasNext() {
        return familyTree.size() > currentId;
    }

    @Override
    public Human next() {
        return familyTree.get(currentId++);
    }
}
