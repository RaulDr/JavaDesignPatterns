package DesignPatterns.State;

class CombinationLock
{
    private int [] combination;
    public String status;
    private boolean failed = false;
    private int digitsEntered = 0;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        reset();
    }

    void reset (){
        digitsEntered = 0;
        failed = false;
        status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        if(status.equals("LOCKED")){
            status = "";
        }
        status+= digit;
        if(combination[digitsEntered] != digit){
            failed = true;
        }
        digitsEntered++;
        if(combination.length == digitsEntered){
            status = failed == true ? "ERROR" : "OPEN";
        }
    }
}
public class Exercice {
}
