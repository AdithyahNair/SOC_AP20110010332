/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculatorws_client_application;

/**
 *
 * @author adithyahnair
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Sum: " + add(3,4));
    }

    private static int add(int n1, int n2) {
        org.me.calculator.client.CalculatorWS_Service service = new org.me.calculator.client.CalculatorWS_Service();
        org.me.calculator.client.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(n1, n2);
    }
    
}
