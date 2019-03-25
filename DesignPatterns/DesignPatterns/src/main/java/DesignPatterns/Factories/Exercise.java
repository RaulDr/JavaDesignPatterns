package DesignPatterns.Factories;

public class Exercise {

    class Person
    {
        public int id;
        public String name;

        public Person(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
    }

    class PersonFactory
    {
        private int id = -1;
        public Person createPerson(String name)
        {
            id++;
            return new Person(id, name);
        }
    }
}
