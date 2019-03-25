package DesignPatterns.Composite;

import java.util.*;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int sum = 0;
        for(ValueContainer container: this){
            sum+= containerSum(container);
        }
        return sum;
    }

    private int containerSum(ValueContainer container){
        int sum = 0;
        for(int i: container){
            sum+=i;
        }
        return sum;
    }
}

class Demo {
    public static void main(String[] args) {
        ArrayList<ValueContainer> valueContainers = new ArrayList<>();
        ManyValues manyValues = new ManyValues();
        manyValues.addAll(Arrays.asList(1,2,3));
        valueContainers.add(manyValues);
        valueContainers.add(new SingleValue(25));
        System.out.println(new MyList(valueContainers).sum());
    }
}