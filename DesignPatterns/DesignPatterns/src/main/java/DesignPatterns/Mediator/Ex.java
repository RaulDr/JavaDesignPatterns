package DesignPatterns.Mediator;

import java.util.ArrayList;
import java.util.List;

class Participant
{
    public int value = 0;
    private Mediator mediator;
    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        mediator.participants.add(this);
    }

    public void say(int n)
    {
        mediator.broadcastValue(n, this);
    }
}

class Mediator
{
    // todo
    List<Participant> participants = new ArrayList<>();

    public void broadcastValue(int n, Participant participant){
        for (Participant p: participants) {
            if(p != participant){
                p.value = n;
            }
        }
    }

}

public class Ex {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Participant p1 = new Participant(mediator);
        Participant p2 = new Participant(mediator);
        p1.say(3);
        p2.say(2);
        System.out.println("p1 = " + p1.value);
        System.out.println("p2 = " + p2.value);
    }
}
