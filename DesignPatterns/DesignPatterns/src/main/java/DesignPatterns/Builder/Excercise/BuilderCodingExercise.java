package DesignPatterns.Builder.Excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Field {
    String name, type;

    public Field(final String name, final String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "public " + type + " " + name + ";";
    }
}

class Class {
    String className;
    List<Field> fields = new ArrayList<>();
    static final int intendSize = 2;

    private String toStringImpl(int intend) {
        final StringBuilder stringBuilder = new StringBuilder();
        String i = String.join("", Collections.nCopies((intend + 1) * intendSize, " ")); //indentation
        final String newLine = System.lineSeparator();
        stringBuilder.append(String.format("public class %s%s", className, newLine)).append(String.format("{%s" ,newLine));
        for (Field field : fields) {
            stringBuilder.append(String.format("%s%s%s",i, field.toString(),newLine));
        }
        stringBuilder.append(String.format("}"));
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}

class CodeBuilder {
    protected Class aClass = new Class();
    public CodeBuilder(String className) {
        aClass.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        aClass.fields.add(new Field(name, type));
        return this;
    }

    public Class build(){
        return aClass;
    }

    @Override
    public String toString() {
        return aClass.toString();
    }
}


public class BuilderCodingExercise {

    public static void main(String[] args) {
        final CodeBuilder person = new CodeBuilder("Person").addField("name", "String");
        System.out.println(person.toString());
    }
}
