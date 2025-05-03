package pl.pp;

public class mojaSiodmaAplikacja {  public static void main(String[] args) {
    Person person1 = new Person();
    person1.forename = "Mateusz";
    person1.surname = "Karmazyn";
    person1.age = 24;
    person1.address = "ul. Zielona 10, Gdańsk";
    person1.birthYear = 2000;

    person1.hiToAll();

    Person person2 = new Person("Dariusz", "Walendziak", 39);
    person2.address = "ul. Słoneczna 15, Poznań";
    person2.birthYear = 1986;

    person2.hiToAll();

    person1.growOld(6);
    person2.growOld(3);

    person1.beYounger();

    person1.hiToAll();
    person2.hiToAll();
}
}






