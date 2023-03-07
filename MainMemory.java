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
        registerA = p1;
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la suma de ambos números y actualizo el registro A
        registerA = (short)(registerA+registerB);
        System.out.println("The sum of "+ p1+" + "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.add(registerA);
        memory.remove(p2);
    }
    
    public static void Minus(short p1, short p2){
        //Saco el primer número de la posición de la memoria en el registro A
        registerA = p1;
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la resta de ambos números y actualizo el registro A
        registerA = (short)(registerA-registerB);
        System.out.println("The subtraction of "+ p1+" - "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.add(registerA);
        memory.remove(p2);
    }

    public static void Multy(short p1, short p2){
        //Saco el primer número de la posición de la memoria en el registro A
        registerA = p1;
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la resta de ambos números y actualizo el registro A
        registerA = (short)(registerA*registerB);
        System.out.println(p1+" Times "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.add(registerA);
        memory.remove(p2);
    }

    public static void Divide(short p1, short p2){
        //Saco el primer número de la posición de la memoria en el registro A
        registerA = p1;
        //Saco el segundo número de la posición de la memoria en el registro B
        registerB = memory.get(p2);
        //Realizo la resta de ambos números y actualizo el registro A
        registerA = (short)(registerA/registerB);
        System.out.println(p1+" / "+ registerB + " is: "+ registerA);
        //Limpio el registro
        memory.add(registerA);
        memory.remove(p2);
    }

    public static void Instruction(String n1){
        Scanner sc = new Scanner(System.in);
        switch(n1){
            case "LOAD": //Recibimos el paquete y lo almacenamos donde tengamos libre
                try {
                    System.out.println("Put a number to save it. ");
                    short n2 = sc.nextShort();
                    Load(n2);
                    PC++;
                    System.out.println("PC: " + PC);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } 
                break;
            case "ADD":
                try {
                    System.out.println("Put a number to add");
                    short n3 = sc.nextShort();
                    System.out.println("Put the second position on memory");
                    short n4 = sc.nextShort();
                    Plus(n3, n4);
                    PC++;
                    System.out.println("PC: " + PC);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "SUB":
                try {
                    System.out.println("Put a number to sub");
                    short n5 = sc.nextShort();
                    System.out.println("Put the second position on memory");
                    short n6 = sc.nextShort();
                    Minus(n5, n6);
                    PC++;
                    System.out.println("PC: " + PC);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                break;
            case "DIV":
                try {
                    System.out.println("Put a number to divide");
                    short n9 = sc.nextShort();
                    System.out.println("Put the second position on memory");
                    short n10 = sc.nextShort();
                    short zeroyn = memory.get(n10);
                    if(zeroyn==0){
                        System.out.println("MATH ERROR");
                        break;
                    } else {
                        Divide(n9, n10);
                        PC++;
                        System.out.println("PC: " + PC);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                break;
            case "MTY":
                try {
                    System.out.println("Put a number to multiply");
                    short n7 = sc.nextShort();
                    System.out.println("Put the second position on memory");
                    short n8 = sc.nextShort();
                    Multy(n7, n8);
                    PC++;
                    System.out.println("PC: " + PC);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            Queue<String> instructions = new LinkedList<>();
            Scanner sc = new Scanner(System.in);
            String input = "";
            while(!input.equals("EXIT")){
                System.out.println("Write an Instruction: ");
                System.out.println("- LDA");
                System.out.println("- ADD");
                System.out.println("- SUB");
                System.out.println("- MTY");
                System.out.println("- DIV");
                input = sc.next();
                switch(input){
                    case "LDA":
                        instructions.offer("LOAD");
                    break;
                    case "ADD":
                        instructions.offer("ADD");
                    break;
                    case "SUB":
                        instructions.offer("SUB");
                    break;
                    case "MTY":
                        instructions.offer("MTY");
                    break;
                    case "DIV":
                        instructions.offer("DIV");
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}