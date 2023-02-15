import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MainMemory{
    static byte PC = 1;
    static ArrayList<Short> memory = new ArrayList<Short>();
    static short registerA = 0;
    static short registerB = 0;
    
    public static void Load(short n){
        memory.add(n);
        System.out.println(n + " Successfully loaded ");
    }
    
    public static void Plus(short p1, short p2){
        //Saco el primer número de la posición de la memoria en el registro A
        registerA = memory.get(p1);
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la suma de ambos números y actualizo el registro A
        registerA = (short)(registerA+registerB);
        System.out.println("The sum of "+ memory.get(p1)+" + "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.remove(p2);
        memory.set(p1, registerA);
    }
    
    public static void Minus(short p1, short p2){
        //Saco el primer número de la posición de la memoria en el registro A
        registerA = memory.get(p1);
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la resta de ambos números y actualizo el registro A
        registerA = (short)(registerA-registerB);
        System.out.println("The subtraction of "+ memory.get(p1)+" - "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.remove(p2);
        memory.set(p1, registerA);
    }

    public static void Instruction(String n1){
        Scanner sc = new Scanner(System.in);
        switch(n1){
            case "LOAD":
                System.out.println("Put a number to save it. ");
                short n2 = sc.nextShort();
                Load(n2);
                PC++;
                System.out.println("PC: " + PC);
                break;
            case "ADD":
                System.out.println("Put the first position on memory");
                short n3 = sc.nextShort();
                System.out.println("Put the second position on memory");
                short n4 = sc.nextShort();
                Plus(n3, n4);
                PC++;
                System.out.println("PC: " + PC);
                break;

            case "SUB":
                System.out.println("Put the first position on memory");
                short n5 = sc.nextShort();
                System.out.println("Put the second position on memory");
                short n6 = sc.nextShort();
                Minus(n5, n6);
                PC++;
                System.out.println("PC: " + PC);
                break;
            default:
                break;
        }
    }

    public static void cls(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println();
        }
    }

    public static void main(String[] args){
        Queue<String> instructions = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(!input.equals("EXIT")){
            System.out.println("Write an Instruction: ");
            System.out.println("- LOAD");
            System.out.println("- ADD");
            System.out.println("- SUB");
            input = sc.next();
            switch(input){
                case "LOAD":
                    instructions.offer("LOAD");
                break;
                case "ADD":
                    instructions.offer("ADD");
                break;
                case "SUB":
                    instructions.offer("SUB");
                break;
                default:
                break;
            }
            while(!instructions.isEmpty()){
                cls();
                System.out.println("Memory: " + memory);
                System.out.println("Queue: " + instructions);
                Instruction(instructions.remove());
            }
        }
        System.out.println("Memory: " + memory);
        System.out.println("Queue: " + instructions);
    }
}
