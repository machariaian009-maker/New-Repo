/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enckk
 */
public class main {
    
    public static void main(String[] args) {
        // Ensure GUI runs on Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true); // ✅ Load Register Form first
            }
        });
    }
}

    

