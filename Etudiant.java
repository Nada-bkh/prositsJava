import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Etudiant implements Management {
    private int id;
    private String nom;
    private int age;

    public Etudiant() {
    }

    public Etudiant(int id, String nom, int age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void displayStudents(List<Etudiant> etudiants, Consumer<Etudiant> con) {
        etudiants.forEach(con);
    }

    @Override
    public void displayStudentsByFilter(List<Etudiant> etudiants, Predicate<Etudiant> pre, Consumer<Etudiant> con) {
        etudiants.stream().filter(pre).forEach(con);
    }

    @Override
    public String returnStudentsNames(List<Etudiant> etudiants, Function<Etudiant, String> fun) {
        StringBuilder names = new StringBuilder();
        etudiants.forEach(student -> names.append(fun.apply(student)).append(", "));
        return names.toString();
    }

    @Override
    public Etudiant createStudent(Supplier<Etudiant> sup) {
        return sup.get();
    }

    @Override
    public List<Etudiant> sortStudentsById(List<Etudiant> etudiants, Comparator<Etudiant> com) {
        etudiants.sort(com);
        return etudiants;
    }

    @Override
    public Stream<Etudiant> convertToStream(List<Etudiant> etudiants) {
        return etudiants.stream();
    }
}
