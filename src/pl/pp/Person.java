package pl.pp;

public class Person {  ;
        String forename;
        String surname;
        int age;
        String address;
        int birthYear;

        public Person() {
            this.forename = "Unknown";
            this.surname = "Unknown";
            this.age = 0;
            this.address = "Unknown";
            this.birthYear = 0;
        }

        public Person(String forename, String surname, int age) {
            this.forename = forename;
            this.surname = surname;
            this.age = age;
        }
        public void hiToAll() {
            System.out.println("Hi, my name is " + forename + " " + surname + ". I'm " + age + " years old and live at " + address + ".");
        }

        public void growOld(int years) {
            this.age += years;
            System.out.println(forename + " has grown older by " + years + " years. New age: " + this.age);
        }

        public void beYounger() {
            if (this.age < 18) {
                System.out.println(forename + " is younger than 18 years old.");
            } else {
                System.out.println(forename + " is 18 or older.");
            }
        }
    }

