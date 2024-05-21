import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();

        Human i = new Human();
        Human wife = new Human();
        Human father = new Human();
        Human mother = new Human();
        Human kidAndrey = new Human();
        Human kidOlga = new Human();

        i.setId(0);
        i.setName("Иванов Сергей Петрович");
        i.setGender(Gender.Male);
        i.setBirthDate(LocalDate.of(1983, 11, 15), null);
        i.setFather(father);
        i.setMother(mother);
        i.setSpouse(wife);
        i.setChildren(kidAndrey);
        i.setChildren(kidOlga);

        father.setId(0);
        father.setName("Иванов Петр Николаевич");
        father.setGender(Gender.Male);
        father.setBirthDate(LocalDate.of(1962, 7, 13), null);
        father.setChildren(i);

        mother.setId(0);
        mother.setName("Иванова Светлана Николаевна");
        mother.setGender(Gender.Female);
        mother.setBirthDate(LocalDate.of(1963, 7, 19), null);
        mother.setChildren(i);

        wife.setId(0);
        wife.setName("Иванова Надежда Сергеевна");
        wife.setGender(Gender.Female);
        wife.setBirthDate(LocalDate.of(1988, 9, 16), null);
        wife.setSpouse(i);
        wife.setChildren(kidAndrey);
        wife.setChildren(kidOlga);

        kidAndrey.setId(0);
        kidAndrey.setName("Иванов Андрей Сергеевич");
        kidAndrey.setGender(Gender.Male);
        kidAndrey.setBirthDate(LocalDate.of(2020, 1, 23), null);
        kidAndrey.setFather(i);
        kidAndrey.setMother(wife);

        kidOlga.setId(0);
        kidOlga.setName("Иванова Ольга Сергеевна");
        kidOlga.setGender(Gender.Female);
        kidOlga.setBirthDate(LocalDate.of(2023, 4, 25), null);
        kidOlga.setFather(i);
        kidOlga.setMother(wife);

        familyTree.setHuman(i);
        familyTree.setHuman(father);
        familyTree.setHuman(mother);
        familyTree.setHuman(wife);
        familyTree.setHuman(kidAndrey);
        familyTree.setHuman(kidOlga);

        System.out.println("Исходное дерево:");
        System.out.println(familyTree);
        System.out.println("Исходный список имен:");
        System.out.println(familyTree.getNameList());
        familyTree.sortByname();
        System.out.println("Отсортированный список имен:");;
        System.out.println(familyTree.getNameList());
        familyTree.sortByBirthDate();
        System.out.println("Отсортированное по дате рождения дерево:");
        System.out.println(familyTree);
        familyTree.sortByAge();
        System.out.println("Отсортированное по возрасту дерево:");
        System.out.println(familyTree);
//        FamilyTree tree = load("familyTree.ser");
//        System.out.println(tree);


//        save(familyTree, "familyTree.ser");
//        System.out.println(loadedFamilyTree);

    }

    private static void save(FamilyTree tree, String filename) {
        Rewritable rewritable = new FileHandler();
        rewritable.saveToFile(tree, filename);
    }

    private static FamilyTree load(String filename) {
        Rewritable rewritable = new FileHandler();
        return (FamilyTree) rewritable.loadFromFile(filename);
    }


}